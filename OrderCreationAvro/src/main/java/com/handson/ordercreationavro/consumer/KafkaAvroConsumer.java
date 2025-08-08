package com.handson.ordercreationavro.consumer;

import com.handson.ordercreationavro.dto.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaAvroConsumer {

    @KafkaListener(topics = "${topic.name}")
    public void read(ConsumerRecord<String, OrderCreatedEvent> consumerRecord) {
        String key = consumerRecord.key();
        OrderCreatedEvent orderCreate = consumerRecord.value();
        log.info("Avro message received for key : {} value : {}", key, orderCreate.toString());

    }
}

