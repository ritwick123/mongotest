package com.crio.mongotest.dtos;

import java.util.List;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Order {

    private Long customerId;

    private List<PurchaseDetails> purchaseDetails;

}
