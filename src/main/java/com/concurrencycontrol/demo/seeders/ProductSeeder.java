package com.concurrencycontrol.demo.seeders;

import com.concurrencycontrol.demo.entities.Product;
import com.concurrencycontrol.demo.repositories.ProductRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;

    private final Faker faker = new Faker();

    @Override
    public void run(String... args) {

        if(productRepository.count() > 0) {
            return;
        }

        for (int i = 1; i <= 2; i++) {
            productRepository.save(Product.builder()
                    .name(faker.commerce().productName())
                    .price(faker.number().randomDouble(2, 10, 100))
                    .quantity(faker.number().numberBetween(1, 10))
                    .build()
            );
        }
    }
}
