package com.concurrencycontrol.infrastructure.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concurrencycontrol.domain.entities.SyncProduct;

@Repository
public interface SyncProductRepository extends JpaRepository<SyncProduct, Long> {
}
