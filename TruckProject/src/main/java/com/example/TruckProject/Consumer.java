package com.example.TruckProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private static final String TOPIC = "trucks.position";

    @Autowired ServiceTruck serviceTruck;

    @KafkaListener(id="h-q", topics=TOPIC)
    public Truck receive(Truck truck, Acknowledgment ack){
        System.out.println(truck.toString());
        serviceTruck.addTruck(truck);
        ack.acknowledge();
        return truck;
    }
}
