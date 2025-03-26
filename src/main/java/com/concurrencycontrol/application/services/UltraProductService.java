package com.concurrencycontrol.application.services;

import com.concurrencycontrol.domain.entities.UltraProduct;
import com.concurrencycontrol.infrastructure.persistence.repositories.UltraProductRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class UltraProductService {

    private final UltraProductRepository productRepository;

    public void buyProduct(Long id, Integer quantity) {

        UltraProduct product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getQuantity() < quantity) {
            throw new RuntimeException("Not enough quantity");
        }

        product.setQuantity(product.getQuantity() - quantity);

        productRepository.save(product);
    }

}
