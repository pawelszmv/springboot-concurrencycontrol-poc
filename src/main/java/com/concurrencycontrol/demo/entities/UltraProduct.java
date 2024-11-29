package com.concurrencycontrol.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UltraProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ultra_product_seq")
    private Long id;

    private String name;

    private Double price;

    private Integer quantity;

    @Version
    private int version;
}
