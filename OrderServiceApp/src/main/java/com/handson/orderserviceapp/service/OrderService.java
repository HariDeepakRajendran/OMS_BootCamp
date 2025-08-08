package com.handson.orderserviceapp.service;

import com.handson.orderserviceapp.entity.Order;
import com.handson.orderserviceapp.event.OrderCreatedEvent;
import com.handson.orderserviceapp.event.OrderEventDocument;
import com.handson.orderserviceapp.kafka.OrderProducer;
import com.handson.orderserviceapp.repository.OrderEventRepository;
import com.handson.orderserviceapp.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderEventRepository eventRepository;
    private final OrderProducer producer;

    public OrderService(OrderRepository orderRepository, OrderEventRepository eventRepository, OrderProducer producer) {
        this.orderRepository = orderRepository;
        this.eventRepository = eventRepository;
        this.producer = producer;
    }

    public Order createOrder(Order order) {
        order.setId(UUID.randomUUID().toString());
        Order saved = orderRepository.save(order);

        OrderCreatedEvent event = OrderCreatedEvent.newBuilder()
                .setOrderNo(saved.getId())
                .setItem(saved.getItem())
                .setQuantity(saved.getQuantity())
                .setPrice(saved.getPrice())
                .build();

        producer.send(event);

        OrderEventDocument doc = new OrderEventDocument();
        doc.setOrderNo(saved.getId());
        doc.setItem(saved.getItem());
        doc.setQuantity(saved.getQuantity());
        doc.setPrice(saved.getPrice());
        eventRepository.save(doc);

        return saved;
    }
}
