package com.handson.mongodborderevents.controller;

import com.handson.mongodborderevents.model.OrderLifeCycleModel;
import com.handson.mongodborderevents.service.OrderLifeCycleService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Validated
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderLifeCycleService service;

    public OrderController(OrderLifeCycleService service) {
        this.service = service;
    }
    @PostMapping("/{orderId}/event")
    public ResponseEntity<String> addEvent(
            @PathVariable String orderId,
            @RequestParam String type,
            @RequestBody Map<String, Object> payload
    ) {
        service.recordEvent(Integer.parseInt(orderId), type, payload);
        return ResponseEntity.ok("Event recorded for order " + orderId);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderLifeCycleModel> getOrderHistory(@PathVariable int orderId) {
        OrderLifeCycleModel doc = service.getOrderHistory(orderId);
        return doc != null ? ResponseEntity.ok(doc) : ResponseEntity.notFound().build();
    }
}
