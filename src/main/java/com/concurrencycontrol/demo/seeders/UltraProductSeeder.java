package com.concurrencycontrol.demo.seeders;

import com.concurrencycontrol.demo.entities.UltraProduct;
import com.concurrencycontrol.demo.repositories.UltraProductRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UltraProductSeeder implements CommandLineRunner {

    private final UltraProductRepository productRepository;

    private final Faker faker = new Faker();

    @Override
    public void run(String... args) {

        if(productRepository.count() > 0) {
            return;
        }

        for (int i = 1; i <= 100; i++) {
            productRepository.save(UltraProduct.builder()
                    .name(faker.commerce().productName())
                    .price(faker.number().randomDouble(2, 10, 100))
                    .quantity(faker.number().numberBetween(1, 10))
                    .build()
            );
        }
    }
}
