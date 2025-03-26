package com.concurrencycontrol.infrastructure.persistence.repositories;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.concurrencycontrol.domain.entities.SuperProduct;

import java.util.Optional;

@Repository
public interface SuperProductRepository extends JpaRepository<SuperProduct, Long> {
    @Override  @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<SuperProduct> findById(Long id);
}
