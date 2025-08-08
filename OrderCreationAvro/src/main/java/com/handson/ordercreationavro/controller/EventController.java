package com.handson.ordercreationavro.controller;

import com.handson.ordercreationavro.dto.OrderCreatedEvent;
import com.handson.ordercreationavro.producer.KafkaAvroProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {
    @Autowired
    private KafkaAvroProducer producer;

    @PostMapping("/events")
    public String sendMessage(@RequestBody OrderCreatedEvent orderCreate) {
        System.out.println("Received event: " + orderCreate);
        producer.send(orderCreate);
        return "message published!";
    }
}

