package com.concurrencycontrol.application.services;

import com.concurrencycontrol.domain.entities.Product;
import com.concurrencycontrol.infrastructure.persistence.repositories.ProductRepository;
import com.github.javafaker.Faker;

import lombok.RequiredArgsConstructor;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final Faker faker = new Faker();

    public void buyProductNormal(Long id, Integer quantity) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        if (product.getQuantity() < quantity) {
            throw new RuntimeException("Not enough quantity");
        }

        product.setQuantity(product.getQuantity() - quantity);

        productRepository.save(product);
    }

    public void createProduct(String name) throws Exception {

        // Generate a fake product and save it in the repository
        // Save the product to the database

        try {
            Product product = Product.builder()
                    // .id(id) // Manually setting the ID
                    .name(name)
                    .price(faker.number().randomDouble(2, 10, 100))
                    .quantity(5) // Fixed quantity for simplicity
                    .build();

            productRepository.save(product);

        } catch (DataIntegrityViolationException e) {
            // This exception occurs if the unique constraint is violated
            throw new Exception("Product with name " + name + " already exists.");
        }
    }

}
