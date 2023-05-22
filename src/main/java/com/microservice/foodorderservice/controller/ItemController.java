package com.microservice.foodorderservice.controller;

import com.microservice.foodorderservice.common.CommonResponse;
import com.microservice.foodorderservice.dto.request.ItemRequest;
import com.microservice.foodorderservice.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/food/item")
@Slf4j
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * This method use to create n& update item
     *
     * @author nethadunb
     * @return CommonResponse
     */
    @PostMapping("/create")
    public CommonResponse create(@RequestBody ItemRequest itemRequest){
        log.info("ItemController.create method accessed!");
        return itemService.create(itemRequest);
    }

    /**
     * This method use to find all active items
     *
     * @author nethadunb
     * @return CommonResponse
     */
    @GetMapping("/find-all")
    public CommonResponse getAll(){
        log.info("ItemController.getAll method accessed !");
        return itemService.findAll();
    }
}
