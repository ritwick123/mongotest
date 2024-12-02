package com.crio.mongotest.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PurchaseDetails {
    
    private Long productId;

    private int quantity;
}
