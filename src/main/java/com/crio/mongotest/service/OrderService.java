package com.crio.mongotest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crio.mongotest.Repository.OrderRepository;
import com.crio.mongotest.dtos.Order;
import com.crio.mongotest.dtos.Product;
import com.crio.mongotest.dtos.PurchaseDetails;
import com.crio.mongotest.entities.OrderEntity;
import com.crio.mongotest.entities.ProductEntity;

@Service
public class OrderService {
    private final AtomicInteger counter = new AtomicInteger(1);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    public long saveOrder(Order order){
        long orderId = counter.getAndIncrement();
        Long customerId = order.getCustomerId();
        List<PurchaseDetails> purchaseDetails = order.getPurchaseDetails();
        List<Product> productList = new ArrayList<>();
        int totalPrice = 0;
        
        for (PurchaseDetails purchaseDetail : purchaseDetails) {
            Long productId = purchaseDetail.getProductId();
            int Quantity = purchaseDetail.getQuantity();
            
            Optional<ProductEntity> purchasedItem = productService.getProductById(productId);
            
            if(purchasedItem.isPresent()){
                Product purchasedProduct = new Product(purchasedItem.get().getName(),purchasedItem.get().getPrice());
                productList.add(purchasedProduct);
                totalPrice = totalPrice + (Quantity * purchasedItem.get().getPrice());
            }
            
        }
        orderRepository.save(new OrderEntity(orderId,customerId,productList,totalPrice));

        return orderId;
    }

    public Optional<OrderEntity> getOrderById(Long id){
        return orderRepository.findById(id);
    }
}
