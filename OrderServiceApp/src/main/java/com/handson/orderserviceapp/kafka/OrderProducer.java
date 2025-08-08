package com.handson.orderserviceapp.kafka;

import com.handson.orderserviceapp.event.OrderCreatedEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderProducer {

    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    @Value("${kafka.topic.order-events:order.events}")
    private String topic;

    public OrderProducer(KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(OrderCreatedEvent event) {
        kafkaTemplate.send(topic, (String) event.getOrderNo(), event);
    }
}


