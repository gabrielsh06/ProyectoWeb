package com.proyecto.web.supplier.service;

import com.proyecto.web.domain.Supplier;
import com.proyecto.web.supplier.dto.request.SupplierCreateRequest;
import com.proyecto.web.supplier.dto.request.SupplierUpdateRequest;
import com.proyecto.web.supplier.dto.response.SupplierResponse;
import com.proyecto.web.supplier.repository.SupplierRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public SupplierResponse getSupplier(Long id) {

        return supplierRepository.findById(id)
                .filter(Supplier::getState)
                .map(SupplierResponse::new)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found"));
    }

    public List<SupplierResponse> getAllSuppliers() {

        return supplierRepository.findAllByStateTrue().stream()
                .map(SupplierResponse::new)
                .toList();
    }

    public SupplierResponse registerSupplier(SupplierCreateRequest supplierCreateRequest) {

        Supplier supplier = supplierCreateRequest.toEntity();
        supplier.setState(true);

        return new SupplierResponse(supplierRepository.save(supplier));
    }

    public SupplierResponse updateSupplier(Long id, SupplierUpdateRequest supplierUpdateRequest) {

        Supplier supplier = supplierRepository.findById(id)
                .filter(Supplier::getState)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found"));
        supplier.setSupplierName(supplierUpdateRequest.supplierName());
        supplier.setDateLastOrder(supplierUpdateRequest.dateLastOrder());
        supplier.setDebt(supplierUpdateRequest.debt());
        supplier.setPaymentStatus(supplierUpdateRequest.paymentStatus());

        return new SupplierResponse(supplierRepository.save(supplier));
    }

    public void deleteSupplier(Long id) {

        Supplier supplier = supplierRepository.findById(id)
                .filter(Supplier::getState)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found"));
        supplier.setState(false);

        supplierRepository.save(supplier);
    }
}