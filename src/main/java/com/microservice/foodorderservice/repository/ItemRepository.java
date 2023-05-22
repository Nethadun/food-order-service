package com.microservice.foodorderservice.repository;

import com.microservice.foodorderservice.model.Category;
import com.microservice.foodorderservice.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item,Integer> {
    List<Item> findAllByIsActive(int i);
}
