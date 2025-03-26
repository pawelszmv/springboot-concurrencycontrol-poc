package com.concurrencycontrol.infrastructure.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.concurrencycontrol.domain.entities.VersionProduct;

@Repository
public interface VersionProductRepository extends JpaRepository<VersionProduct, Long> { }
