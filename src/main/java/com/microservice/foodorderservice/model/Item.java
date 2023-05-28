package com.microservice.foodorderservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "item")
public class Item {
    private Integer id;
    private String name;
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @Column(name = "is_active", columnDefinition = "int default 1")
    private Integer isActive;
    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;
}
