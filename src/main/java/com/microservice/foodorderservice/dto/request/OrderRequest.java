package com.microservice.foodorderservice.dto.request;

import com.microservice.foodorderservice.model.OrderDetails;
import com.microservice.foodorderservice.model.Payment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderRequest {
    private Integer userId;
    private List<OrderDetails> orderDetailsList;
    private Payment payment;
}
