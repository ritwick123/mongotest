package com.crio.mongotest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crio.mongotest.dtos.Customer;
import com.crio.mongotest.dtos.Order;
import com.crio.mongotest.dtos.Product;
import com.crio.mongotest.entities.CustomerEntity;
import com.crio.mongotest.entities.ProductEntity;
import com.crio.mongotest.service.CustomerService;
import com.crio.mongotest.service.OrderService;
import com.crio.mongotest.service.ProductService;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/saveCustomer")
    public Long saveCust(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }

    @GetMapping("/getCustomer/{id}")
    public Optional<CustomerEntity> getCustById(@PathVariable  int id){
      return customerService.getCustomerById((long)id);
    }

    @PostMapping("/saveProduct")
    public long saveProd(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/getProduct/{id}")
    public Optional<ProductEntity> getProductById(@PathVariable Long id){

        return productService.getProductById(id);
    } 

    @PostMapping("/saveOrder")
    public long saveOrd(@RequestBody Order order){
       return orderService.saveOrder(order);
    }
}
