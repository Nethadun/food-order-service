package com.microservice.foodorderservice.repository;

import com.microservice.foodorderservice.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetails, Integer> {
}
