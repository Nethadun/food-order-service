package com.microservice.foodorderservice.service;

import com.microservice.foodorderservice.common.CommonResponse;
import com.microservice.foodorderservice.dto.request.ItemRequest;

public interface ItemService {
    CommonResponse create(ItemRequest itemRequest);

    CommonResponse findAll();
}
