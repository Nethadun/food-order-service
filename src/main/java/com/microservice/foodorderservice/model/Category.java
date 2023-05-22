package com.microservice.foodorderservice.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String name;
    @Column(name = "is_active", columnDefinition = "int default 1")
    private Integer isActive;
    @Column(name = "created_at")
    @CreationTimestamp
    private Timestamp createdAt;
}
