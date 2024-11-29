package com.concurrencycontrol.demo.services;

import com.concurrencycontrol.demo.entities.SuperProduct;
import com.concurrencycontrol.demo.repositories.SuperProductRepository;
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
