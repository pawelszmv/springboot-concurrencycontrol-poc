package com.concurrencycontrol.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @Builder @NoArgsConstructor @AllArgsConstructor
public class LockProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lock_product_seq")
    private Long id;

    private String name;

    private Double price;

    private Integer quantity;
}
