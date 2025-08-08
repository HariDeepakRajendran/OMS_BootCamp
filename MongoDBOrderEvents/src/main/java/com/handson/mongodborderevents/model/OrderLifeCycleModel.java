package com.handson.mongodborderevents.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@Getter
@Document(collection = "order_lifecycle")
public class OrderLifeCycleModel {

    @Id
    private int orderId;

    private List<OrderEvent> events = new ArrayList<>();

    public OrderLifeCycleModel() {}

    public OrderLifeCycleModel(int orderId) {
        this.orderId = orderId;
    }

    public void addEvent(OrderEvent event) {
        this.events.add(event);
    }
}
