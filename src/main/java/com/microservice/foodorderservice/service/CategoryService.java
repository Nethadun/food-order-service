package com.microservice.foodorderservice.service;

import com.microservice.foodorderservice.common.CommonResponse;
import com.microservice.foodorderservice.dto.request.CategoryRequest;
import com.microservice.foodorderservice.model.Category;

public interface CategoryService {
    CommonResponse findAll();

    CommonResponse create(CategoryRequest categoryRequest);
}
