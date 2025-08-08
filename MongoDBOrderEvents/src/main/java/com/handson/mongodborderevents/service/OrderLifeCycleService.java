package com.handson.mongodborderevents.service;

import com.handson.mongodborderevents.model.OrderEvent;
import com.handson.mongodborderevents.model.OrderLifeCycleModel;
import com.handson.mongodborderevents.repository.OrderLifeCycleRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderLifeCycleService {
    private final OrderLifeCycleRepository repository;

    public OrderLifeCycleService(OrderLifeCycleRepository repository) {
        this.repository = repository;
    }

    public void recordEvent(int orderId, String type, Map<String, Object> inputPayload) {
        OrderLifeCycleModel document = repository.findById(orderId).
                orElse(new OrderLifeCycleModel(orderId));

        document.addEvent(new OrderEvent(type, inputPayload));
        repository.save(document);
    }

    public OrderLifeCycleModel getOrderHistory(int orderId) {
        return repository.findById(orderId).orElse(null);
    }
}
