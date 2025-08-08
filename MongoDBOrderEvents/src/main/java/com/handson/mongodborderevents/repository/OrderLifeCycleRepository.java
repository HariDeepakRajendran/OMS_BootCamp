package com.handson.mongodborderevents.repository;

import com.handson.mongodborderevents.model.OrderLifeCycleModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderLifeCycleRepository extends MongoRepository<OrderLifeCycleModel,Integer> {
}
