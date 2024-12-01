package com.crio.mongotest.dtos;

// import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
// @Document(collection = "product")
public class Product {

    private String name;

    private int price;

    // private int quantity;
}
