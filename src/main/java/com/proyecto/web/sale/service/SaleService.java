package com.proyecto.web.sale.service;

import com.proyecto.web.customer.repository.CustomerRepository;
import com.proyecto.web.domain.Sale;
import com.proyecto.web.domain.SaleDetail;
import com.proyecto.web.product.repository.ProductRepository;
import com.proyecto.web.sale.dto.request.SaleCreateRequest;
import com.proyecto.web.sale.dto.request.SaleItemRequest;
import com.proyecto.web.sale.dto.response.SaleResponse;
import com.proyecto.web.sale.repository.SaleRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final CustomerRepository customerRepository;

    public SaleService(SaleRepository saleRepository,
            ProductRepository productRepository,
            CustomerRepository customerRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional
    public SaleResponse registerSale(SaleCreateRequest request) {

        Sale sale = new Sale();
        sale.setDate(LocalDateTime.now());

        // Cliente opcional
        if (request.customerId() != null) {
            sale.setCustomer(customerRepository.findById(request.customerId())
                    .orElseThrow(() -> new EntityNotFoundException("Cliente no encontrado")));
        }

        List<SaleDetail> details = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;

        for (SaleItemRequest item : request.items()) {
            var product = productRepository.findById(item.productId())
                    .filter(p -> p.getState())
                    .orElseThrow(() -> new EntityNotFoundException("Producto no encontrado: " + item.productId()));

            if (product.getStock() < item.quantity()) {
                throw new IllegalArgumentException("Stock insuficiente para: " + product.getName());
            }

            // Descontar stock
            product.setStock(product.getStock() - item.quantity());
            productRepository.save(product);

            // Crear detalle
            SaleDetail detail = new SaleDetail();
            detail.setProduct(product);
            detail.setQuantity(item.quantity());
            detail.setUnitPrice(product.getSalePrice());
            detail.setSubtotal(product.getSalePrice().multiply(BigDecimal.valueOf(item.quantity())));
            detail.setSale(sale);

            details.add(detail);
            total = total.add(detail.getSubtotal());
        }

        sale.setDetails(details);
        sale.setTotal(total);

        return new SaleResponse(saleRepository.save(sale));
    }
}