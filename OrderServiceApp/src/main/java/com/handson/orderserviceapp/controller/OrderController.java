package com.handson.orderserviceapp.controller;

import com.handson.orderserviceapp.entity.Order;
import com.handson.orderserviceapp.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<Order> create(@RequestBody Order order) {
        Order created = orderService.createOrder(order);
        System.out.println("Order created: " + created);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}

