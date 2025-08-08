package com.handson.ordercreationavro.producer;

import com.handson.ordercreationavro.dto.OrderCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class KafkaAvroProducer {

    @Value("${topic.name}")
    private String topicName;

    @Autowired
    private KafkaTemplate<String, OrderCreatedEvent> template;


    public void send(OrderCreatedEvent orderCreate){
        CompletableFuture<SendResult<String, OrderCreatedEvent>> future = template.send(topicName, UUID.randomUUID().toString(),orderCreate);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message=[" + orderCreate +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message=[" +
                        orderCreate + "] due to : " + ex.getMessage());
            }
        });
    }
}
