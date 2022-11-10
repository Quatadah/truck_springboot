package com.example.TruckProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class ServiceTruck {
    private Map<Integer, Truck> trucks = new HashMap<Integer, Truck>();

    public Truck getById( int id){
        return trucks.get(id);
    }

    public void addTruck(Truck truck){
        trucks.put(truck.getTruckId(), truck);
    }


}
