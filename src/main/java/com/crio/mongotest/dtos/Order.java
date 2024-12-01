package com.crio.mongotest.dtos;

import java.util.List;

// import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
// @Document(collection = "order")
public class Order {

    private Long customerId;

    private List<Product> products;

    // private int totalPrice;
    
}
