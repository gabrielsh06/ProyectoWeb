package com.proyecto.web.sale.controller;

import com.proyecto.web.sale.dto.request.SaleCreateRequest;
import com.proyecto.web.sale.dto.response.SaleResponse;
import com.proyecto.web.sale.service.SaleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sale")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public ResponseEntity<SaleResponse> registerSale(@Valid @RequestBody SaleCreateRequest request) {
        SaleResponse response = saleService.registerSale(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}