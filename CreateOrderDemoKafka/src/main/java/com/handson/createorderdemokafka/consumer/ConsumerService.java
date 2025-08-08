package com.handson.createorderdemokafka.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {
    @KafkaListener(topics = "order.created", groupId = "my-group")
    public void consume(String message) {
        System.out.println("Received message: " + message);
    }
}
