package com.crio.mongotest.service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import com.crio.mongotest.Repository.CustomerRepository;
import com.crio.mongotest.Repository.ProductRepository;
// import com.crio.mongotest.dtos.Customer;
import com.crio.mongotest.dtos.Product;
// import com.crio.mongotest.entities.CustomerEntity;
import com.crio.mongotest.entities.ProductEntity;

@Service
public class ProductService {
    

    private final AtomicInteger counter = new AtomicInteger(1);

    @Autowired
    private ProductRepository productRepository;

    public long saveProduct(Product product){

        long id = counter.getAndIncrement();
        String name = product.getName();
        int price = product.getPrice();
        productRepository.save(new ProductEntity(id,name,price));

        return id;
    }

    public Optional<ProductEntity> getProductById(Long id){
         return productRepository.findById(id);
    }
}
