package com.proyecto.web.product.repository;

import com.proyecto.web.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByStateTrue();

    @Query("SELECT p FROM Product p WHERE " +
            "(LOWER(p.name) LIKE LOWER(CONCAT('%', :term, '%')) OR " +
            "LOWER(p.code) LIKE LOWER(CONCAT('%', :term, '%'))) " +
            "AND p.state = true")
    List<Product> searchByNameOrCode(@Param("term") String term);
}