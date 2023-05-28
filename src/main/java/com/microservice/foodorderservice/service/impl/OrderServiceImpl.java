package com.microservice.foodorderservice.service.impl;

import com.microservice.foodorderservice.common.CommonConstants;
import com.microservice.foodorderservice.common.CommonResponse;
import com.microservice.foodorderservice.dto.request.OrderRequest;
import com.microservice.foodorderservice.model.Order;
import com.microservice.foodorderservice.model.Payment;
import com.microservice.foodorderservice.repository.OrderDetailRepository;
import com.microservice.foodorderservice.repository.OrderRepository;
import com.microservice.foodorderservice.repository.PaymentRepository;
import com.microservice.foodorderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    /**
     * This method use to make order for list of pizzas
     * @param orderRequest
     * @return CommonResponse
     */
    @Override
    public CommonResponse makeOrder(OrderRequest orderRequest) {
        log.info("OrderServiceImpl.makeOrder method accessed !");
        CommonResponse commonResponse= new CommonResponse();
        Order order=new Order();
        try {
            order.setUserId(orderRequest.getUserId());
            Order save = orderRepository.save(order);
            if (save.getId()!= null){
                orderRequest.getOrderDetailsList().forEach(orderDetails -> {
                    orderDetails.setOrderId(save.getId());
                    orderDetailRepository.save(orderDetails);
                });
                paymentRepository.save(orderRequest.getPayment());
                commonResponse.setStatus(HttpStatus.OK.value());
                commonResponse.setMessage(CommonConstants.OK);
                commonResponse.setPayload(save);
            }else {
                commonResponse.setStatus(HttpStatus.BAD_REQUEST.value());
                commonResponse.setMessage(CommonConstants.FAILED);
                commonResponse.setPayload(new ArrayList<>());
            }
        }catch (Exception ex){
            log.error("Error in OrderServiceImpl.makeOrder method : {}",ex.getMessage());
            commonResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            commonResponse.setMessage(CommonConstants.INTERNAL_SERVER_ERROR);
            commonResponse.setPayload(new ArrayList<>());
        }
        return commonResponse;
    }
}
