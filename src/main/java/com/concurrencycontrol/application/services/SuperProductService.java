package com.concurrencycontrol.application.services;

import com.concurrencycontrol.domain.entities.SuperProduct;
import com.concurrencycontrol.infrastructure.persistence.repositories.SuperProductRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @RequiredArgsConstructor
public class SuperProductService {

    private final SuperProductRepository superProductRepository;

    @Transactional
    public void buyProduct(Long id, Integer quantity) {

        SuperProduct product = superProductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getQuantity() < quantity) {
            throw new RuntimeException("Not enough quantity");
        }

        product.setQuantity(product.getQuantity() - quantity);

    }

}
