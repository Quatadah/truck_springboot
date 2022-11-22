package com.example.TruckProject;

import java.util.Map;

import org.apache.kafka.common.TopicPartition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.ConsumerSeekAware.ConsumerSeekCallback;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    private static final String TOPIC = "trucks.position";

    @Autowired ServiceTruck serviceTruck;
    
    public void onPartitionsAssigned(Map<TopicPartition, Long> assignments, ConsumerSeekCallback callback) {        
        callback.seekToTimestamp(assignments.keySet(), System.currentTimeMillis() - 60 * 60 * 1000);
    }

    @KafkaListener(id="h-q", topics=TOPIC)
    public Truck receive(Truck truck, Acknowledgment ack){
        System.out.println(truck.toString());
        serviceTruck.addTruck(truck);
        ack.acknowledge();
        return truck;
    }
}
