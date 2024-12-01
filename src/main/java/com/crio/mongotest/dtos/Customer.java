package com.crio.mongotest.dtos;

// import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
// @Document(collection = "customers")
public class Customer {
    
    private String name;

    private String email;

    // private String address;
    
    // private int phone;
}
