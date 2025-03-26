package com.concurrencycontrol.infrastructure.persistence.repositories;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import com.concurrencycontrol.domain.entities.LockProduct;

import java.util.Optional;

@Repository
public interface LockProductRepository extends JpaRepository<LockProduct, Long> {
    @Override
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<LockProduct> findById(Long id);
}
