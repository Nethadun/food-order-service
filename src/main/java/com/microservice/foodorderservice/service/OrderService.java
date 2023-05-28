package com.microservice.foodorderservice.service;

import com.microservice.foodorderservice.common.CommonResponse;
import com.microservice.foodorderservice.dto.request.OrderRequest;

public interface OrderService {
    CommonResponse makeOrder(OrderRequest orderRequest);
}
