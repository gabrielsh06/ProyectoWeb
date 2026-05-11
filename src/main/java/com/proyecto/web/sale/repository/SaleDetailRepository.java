package com.proyecto.web.sale.repository;

import com.proyecto.web.domain.SaleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleDetailRepository extends JpaRepository<SaleDetail, Long> {

    // Agrupa por nombre y categoría, suma cantidades y subtotales
    @Query("SELECT d.product.name, d.product.category, SUM(d.quantity), SUM(d.subtotal) " +
           "FROM SaleDetail d " +
           "GROUP BY d.product.name, d.product.category " +
           "ORDER BY SUM(d.quantity) DESC")
    List<Object[]> getTopSellingProducts();
}