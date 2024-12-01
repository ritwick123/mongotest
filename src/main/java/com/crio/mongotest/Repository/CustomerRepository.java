package com.crio.mongotest.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crio.mongotest.entities.CustomerEntity;

public interface CustomerRepository extends MongoRepository<CustomerEntity,Long>{
    
}
