package com.handson.orderserviceapp.repository;

import com.handson.orderserviceapp.event.OrderEventDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderEventRepository extends MongoRepository<OrderEventDocument, String> {}

