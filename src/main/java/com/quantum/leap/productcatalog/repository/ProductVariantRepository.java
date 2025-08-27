package com.quantum.leap.productcatalog.repository;

import com.quantum.leap.productcatalog.entity.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductVariantRepository extends JpaRepository<ProductVariant, Long>, JpaSpecificationExecutor<ProductVariant> {
}

