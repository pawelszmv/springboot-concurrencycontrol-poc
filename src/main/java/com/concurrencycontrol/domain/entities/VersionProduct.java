package com.concurrencycontrol.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @Builder @NoArgsConstructor @AllArgsConstructor
public class VersionProduct {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "version_product_seq")
    private Long id;

    private String name;

    private Double price;

    private Integer quantity;
    
    @Version
    private int version;
}
