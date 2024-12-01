package com.crio.mongotest.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.mongotest.Repository.OrderRepository;
import com.crio.mongotest.dtos.Order;
import com.crio.mongotest.dtos.Product;
import com.crio.mongotest.entities.OrderEntity;

@Service
public class OrderService {
    private final AtomicInteger counter = new AtomicInteger(1);

    @Autowired
    private OrderRepository orderRepository;

    public long saveOrder(Order order){
        long orderId = counter.getAndIncrement();
        Long customerId = order.getCustomerId();
        List<Product> products = order.getProducts();

        orderRepository.save(new OrderEntity(orderId,customerId,products));

        return orderId;
    }

    public Optional<OrderEntity> getOrderById(Long id){
        return orderRepository.findById(id);
    }
}
