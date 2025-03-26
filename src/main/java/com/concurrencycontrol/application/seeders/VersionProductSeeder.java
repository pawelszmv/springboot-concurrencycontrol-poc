package com.concurrencycontrol.application.seeders;

import com.concurrencycontrol.domain.entities.VersionProduct;
import com.concurrencycontrol.infrastructure.persistence.repositories.VersionProductRepository;
import com.github.javafaker.Faker;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VersionProductSeeder implements CommandLineRunner {

    private final VersionProductRepository productRepository;

    private final Faker faker = new Faker();

    @Override
    public void run(String... args) {

        if(productRepository.count() > 0) {
            return;
        }

        for (int i = 1; i <= 2; i++) {
            productRepository.save(VersionProduct.builder()
                    .name(faker.commerce().productName())
                    .price(faker.number().randomDouble(2, 10, 100))
                    //.quantity(faker.number().numberBetween(1, 10))
                    .quantity(5)
                    .build()
            );
        }
    }
}
