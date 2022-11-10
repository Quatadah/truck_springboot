package com.example.TruckProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class ServiceTruck {
    private Map<Integer, Truck> trucks = new HashMap<Integer, Truck>();

    @Autowired
    WebClient truckClient;

    public static final String TRUCK_URL = "http://breisen.datamix.ovh:8080";

    @Bean
    public WebClient webClient(WebClient.Builder builder) {
        return builder.baseUrl(TRUCK_URL).build();
    }

    public Truck getById( int id){
        return trucks.get(id);
    }

    public void addTruck(Truck truck){
        trucks.put(truck.getTruckId(), truck);
    }

    public String getUrlById(int id){
        return truckClient.post().uri("/map").body(Mono.just(getById(id).getPosition()), Position.class).retrieve().bodyToMono(String.class).block();
    }

}
