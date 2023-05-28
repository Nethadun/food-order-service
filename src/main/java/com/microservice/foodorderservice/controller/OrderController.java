package com.microservice.foodorderservice.controller;

import com.microservice.foodorderservice.common.CommonResponse;
import com.microservice.foodorderservice.dto.request.OrderRequest;
import com.microservice.foodorderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/food/item")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;
    public CommonResponse makeOrder(@RequestBody OrderRequest orderRequest){
        log.info("OrderController.makeOrder method accessed!");
        return or
    }
}
