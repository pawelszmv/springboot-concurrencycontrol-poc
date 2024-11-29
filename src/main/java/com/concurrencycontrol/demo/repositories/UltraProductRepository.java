package com.concurrencycontrol.demo.repositories;

import com.concurrencycontrol.demo.entities.UltraProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UltraProductRepository extends JpaRepository<UltraProduct, Long> { }
