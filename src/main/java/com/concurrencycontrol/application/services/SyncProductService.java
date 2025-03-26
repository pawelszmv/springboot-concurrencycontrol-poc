package com.concurrencycontrol.application.services;

import com.concurrencycontrol.domain.entities.SyncProduct;
import com.concurrencycontrol.infrastructure.persistence.repositories.SyncProductRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class SyncProductService {

    private final SyncProductRepository productRepository;


    public synchronized void buyProductSynchronized(Long id, Integer quantity) {

        SyncProduct product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sync Product not found"));

        if (product.getQuantity() < quantity) {
            throw new RuntimeException("Not enough quantity");
        }

        product.setQuantity(product.getQuantity() - quantity);

        productRepository.save(product);
    }

}
