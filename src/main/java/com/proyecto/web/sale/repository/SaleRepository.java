package com.proyecto.web.sale.repository;

import com.proyecto.web.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    // 1. Suma total de ventas
    @Query("SELECT SUM(s.total) FROM Sale s")
    BigDecimal calculateTotalSales();

    // 2. Contar transacciones
    @Query("SELECT COUNT(s) FROM Sale s")
    Long countTransactions();
}