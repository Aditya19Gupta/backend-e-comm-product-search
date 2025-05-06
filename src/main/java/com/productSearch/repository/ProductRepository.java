package com.productSearch.repository;

import com.productSearch.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Query("SELECT p FROM Product p WHERE " +
            "LOWER(p.name) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(p.brand) LIKE LOWER(CONCAT('%', :search, '%')) OR " +
            "LOWER(p.category) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<Product> findByNameContainingIgnoreCaseOrBrandContainingIgnoreCase(@Param("search") String search);
}
