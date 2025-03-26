package com.concurrencycontrol.infrastructure.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concurrencycontrol.domain.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
