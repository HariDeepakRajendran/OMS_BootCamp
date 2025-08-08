package com.handson.orderserviceapp.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document("order_events")
@Getter
@Setter
public class OrderEventDocument {
    @Id
    private String id;
    private String orderNo;
    private String item;
    private int quantity;
    private double price;
    private Instant timestamp = Instant.now();

    // Getters and Setters
}


