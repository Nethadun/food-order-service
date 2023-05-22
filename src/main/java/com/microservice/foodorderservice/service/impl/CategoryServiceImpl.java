package com.microservice.foodorderservice.service.impl;

import com.microservice.foodorderservice.common.CommonConstants;
import com.microservice.foodorderservice.common.CommonResponse;
import com.microservice.foodorderservice.dto.request.CategoryRequest;
import com.microservice.foodorderservice.model.Category;
import com.microservice.foodorderservice.repository.CategoryRepository;
import com.microservice.foodorderservice.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public CommonResponse findAll() {
        log.info("CategoryServiceImpl.findAll method accessed !");
        CommonResponse commonResponse= new CommonResponse();
        try {
            List<Category> allByIsActive = categoryRepository.findAllByIsActive(1);
            if (allByIsActive.isEmpty()){
                commonResponse.setStatus(HttpStatus.NOT_FOUND.value());
                commonResponse.setMessage(CommonConstants.NOT_FOUND);
                commonResponse.setPayload(new ArrayList<>());
            }else {
                commonResponse.setStatus(HttpStatus.FOUND.value());
                commonResponse.setMessage(CommonConstants.FOUND);
                commonResponse.setPayload(allByIsActive);
            }
        }catch (Exception ex){
            log.error("Error in CategoryServiceImpl.findAll method : {}",ex.getMessage());
            commonResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            commonResponse.setMessage(CommonConstants.INTERNAL_SERVER_ERROR);
            commonResponse.setPayload(new ArrayList<>());
        }
        return commonResponse;
    }

    @Override
    public CommonResponse create(CategoryRequest categoryRequest) {
        log.info("CategoryServiceImpl.findAll method accessed !");
        CommonResponse commonResponse= new CommonResponse();
        Category category = new Category();
        try {
           if (categoryRequest.getId() != 0){
               Optional<Category> byId = categoryRepository.findById(categoryRequest.getId());
               if (byId.isPresent()){
                   Category category1 = byId.get();
                   category1.setName(categoryRequest.getName());
                   category1.setIsActive(1);
                   Category save = categoryRepository.save(category1);
                   if (save.getId() != 0){
                       commonResponse.setStatus(HttpStatus.OK.value());
                       commonResponse.setMessage(CommonConstants.OK);
                       commonResponse.setPayload(save);
                   }else {
                       commonResponse.setStatus(HttpStatus.BAD_REQUEST.value());
                       commonResponse.setMessage(CommonConstants.FAILED);
                       commonResponse.setPayload(new ArrayList<>());
                   }
               }
           }else {
               category.setName(categoryRequest.getName());
               category.setIsActive(1);
               Category save = categoryRepository.save(category);
               if (save.getId() != 0){
                   commonResponse.setStatus(HttpStatus.OK.value());
                   commonResponse.setMessage(CommonConstants.OK);
                   commonResponse.setPayload(save);
               }else {
                   commonResponse.setStatus(HttpStatus.BAD_REQUEST.value());
                   commonResponse.setMessage(CommonConstants.FAILED);
                   commonResponse.setPayload(new ArrayList<>());
               }
           }

        }catch (Exception ex){
            log.error("Error in CategoryServiceImpl.create method : {}",ex.getMessage());
            commonResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            commonResponse.setMessage(CommonConstants.INTERNAL_SERVER_ERROR);
            commonResponse.setPayload(new ArrayList<>());
        }
        return commonResponse;
    }
}
