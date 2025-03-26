package com.concurrencycontrol.application.services;

import com.concurrencycontrol.domain.entities.VersionProduct;
import com.concurrencycontrol.infrastructure.persistence.repositories.VersionProductRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class VersionProductService {

    private final VersionProductRepository productRepository;

    public void buyProduct(Long id, Integer quantity) {

        VersionProduct product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getQuantity() < quantity) {
            throw new RuntimeException("Not enough quantity");
        }

        product.setQuantity(product.getQuantity() - quantity);

        productRepository.save(product);
    }

}
