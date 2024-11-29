package com.concurrencycontrol.demo.services;

import com.concurrencycontrol.demo.entities.Product;
import com.concurrencycontrol.demo.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public synchronized void buyProduct(Long id, Integer quantity) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getQuantity() < quantity) {
            throw new RuntimeException("Not enough quantity");
        }

        product.setQuantity(product.getQuantity() - quantity);

        productRepository.save(product);
    }

}
