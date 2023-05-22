package com.microservice.foodorderservice.controller;

import com.microservice.foodorderservice.common.CommonResponse;
import com.microservice.foodorderservice.dto.request.CategoryRequest;
import com.microservice.foodorderservice.model.Category;
import com.microservice.foodorderservice.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/food/category")
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * This method use to find all active categories
     *
     * @author nethadunb
     * @return CommonResponse
     */
    @GetMapping("/find-all")
    public CommonResponse getAll(){
        log.info("CategoryController.getAll method accessed !");
        return categoryService.findAll();
    }
    /**
     * This method use to create n& update category
     *
     * @author nethadunb
     * @return CommonResponse
     */
    @PostMapping("/create")
    public CommonResponse create(@RequestBody CategoryRequest categoryRequest){
        log.info("CategoryController.create method accessed !");
        return categoryService.create(categoryRequest);
    }
}
