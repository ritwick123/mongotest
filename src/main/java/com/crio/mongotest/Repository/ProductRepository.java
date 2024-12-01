package com.crio.mongotest.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.crio.mongotest.entities.ProductEntity;

public interface ProductRepository extends MongoRepository<ProductEntity,Long>{
    
}
