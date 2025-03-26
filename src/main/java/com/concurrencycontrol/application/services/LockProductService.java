package com.concurrencycontrol.application.services;

import com.concurrencycontrol.domain.entities.LockProduct;
import com.concurrencycontrol.infrastructure.persistence.repositories.LockProductRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @RequiredArgsConstructor
public class LockProductService {

    private final LockProductRepository superProductRepository;

    @Transactional
    public void buyProduct(Long id, Integer quantity) {

        LockProduct product = superProductRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lock Product not found"));

        if (product.getQuantity() < quantity) {
            throw new RuntimeException("Not enough quantity");
        }

        product.setQuantity(product.getQuantity() - quantity);

    }

}
