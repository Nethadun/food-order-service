package com.microservice.foodorderservice.service.impl;

import com.microservice.foodorderservice.common.CommonConstants;
import com.microservice.foodorderservice.common.CommonResponse;
import com.microservice.foodorderservice.dto.request.ItemRequest;
import com.microservice.foodorderservice.model.Item;
import com.microservice.foodorderservice.repository.ItemRepository;
import com.microservice.foodorderservice.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ItemServiceImpl  implements ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Override
    public CommonResponse create(ItemRequest itemRequest) {
        log.info("ItemServiceImpl.create method accessed!");
        CommonResponse commonResponse = new CommonResponse();
        try{
            if (itemRequest.getId()!= 0){
                Optional<Item> byId = itemRepository.findById(itemRequest.getId());
                if (byId.isPresent()){
                    Item item = byId.get();
                    item.setName(itemRequest.getName());
                    item.setCategoryId(itemRequest.getCategoryId());
                    itemRepository.save(item);
                }
                Item item = new Item();
                item.setName(itemRequest.getName());
                item.setCategoryId(itemRequest.getCategoryId());
                Item save = itemRepository.save(item);
                if (save.getId() != 0){
                    commonResponse.setStatus(HttpStatus.OK.value());
                    commonResponse.setMessage(CommonConstants.OK);
                    commonResponse.setPayload(save);
                }else {
                    commonResponse.setStatus(HttpStatus.BAD_REQUEST.value());
                    commonResponse.setMessage(CommonConstants.FAILED);
                    commonResponse.setPayload(new ArrayList<>());
                }
            }else {
                Item item = new Item();
                item.setName(itemRequest.getName());
                item.setCategoryId(itemRequest.getCategoryId());
                Item save = itemRepository.save(item);
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
            log.error("Error in ItemServiceImpl.create method : {}",ex.getMessage());
            commonResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            commonResponse.setMessage(CommonConstants.INTERNAL_SERVER_ERROR);
            commonResponse.setPayload(new ArrayList<>());
        }
        return commonResponse;
    }

    @Override
    public CommonResponse findAll() {
        log.info("ItemServiceImpl.findAll method accessed !");
        CommonResponse commonResponse= new CommonResponse();
        try {
            List<Item> allByIsActive = itemRepository.findAllByIsActive(1);
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
            log.error("Error in ItemServiceImpl.findAll method : {}",ex.getMessage());
            commonResponse.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            commonResponse.setMessage(CommonConstants.INTERNAL_SERVER_ERROR);
            commonResponse.setPayload(new ArrayList<>());
        }
        return commonResponse;
    }
}

