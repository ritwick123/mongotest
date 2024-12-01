package com.crio.mongotest.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crio.mongotest.entities.OrderEntity;

public interface OrderRepository extends MongoRepository<OrderEntity,Long>{
    
}