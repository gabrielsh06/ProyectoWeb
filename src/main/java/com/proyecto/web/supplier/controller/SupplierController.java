package com.proyecto.web.supplier.controller;

import com.proyecto.web.supplier.dto.request.SupplierCreateRequest;
import com.proyecto.web.supplier.dto.request.SupplierUpdateRequest;
import com.proyecto.web.supplier.dto.response.SupplierResponse;
import com.proyecto.web.supplier.service.SupplierService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/supplier")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponse> getSupplier(@PathVariable Long id) {

        SupplierResponse response = supplierService.getSupplier(id);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<List<SupplierResponse>> getAllSuppliers() {

        List<SupplierResponse> response = supplierService.getAllSuppliers();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping()
    public ResponseEntity<SupplierResponse> registerSupplier(
            @Valid @RequestBody SupplierCreateRequest supplierCreateRequest) {

        SupplierResponse response = supplierService.registerSupplier(supplierCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("{id}")
    public ResponseEntity<SupplierResponse> updateSupplier(@PathVariable Long id,
                                                                @Valid @RequestBody SupplierUpdateRequest supplierUpdateRequest) {

        SupplierResponse response = supplierService.updateSupplier(id, supplierUpdateRequest);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {

        supplierService.deleteSupplier(id);
        return ResponseEntity.noContent().build();
    }
}