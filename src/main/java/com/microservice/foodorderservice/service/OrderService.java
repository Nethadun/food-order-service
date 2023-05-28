package com.microservice.foodorderservice.service;

import com.microservice.foodorderservice.common.CommonResponse;
import com.microservice.foodorderservice.dto.request.OrderRequest;

public interface OrderService {
    /**
     * This method use to make order for list of pizzas
     * @param orderRequest
     * @return CommonResponse
     */
    CommonResponse makeOrder(OrderRequest orderRequest);
}
