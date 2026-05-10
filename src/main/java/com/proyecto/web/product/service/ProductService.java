package com.proyecto.web.product.service;

import com.proyecto.web.domain.Product;
import com.proyecto.web.domain.Supplier;
import com.proyecto.web.product.dto.request.ProductCreateRequest;
import com.proyecto.web.product.dto.request.ProductUpdateRequest;
import com.proyecto.web.product.dto.response.ProductResponse;
import com.proyecto.web.product.repository.ProductRepository;
import com.proyecto.web.supplier.repository.SupplierRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final SupplierRepository supplierRepository;

    public ProductService(ProductRepository productRepository,  SupplierRepository supplierRepository) {
        this.productRepository = productRepository;
        this.supplierRepository = supplierRepository;
    }

    public ProductResponse getProduct(Long id) {

        return productRepository.findById(id)
                .filter(Product::getState)
                .map(ProductResponse::new)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    public List<ProductResponse> getAllProducts() {

        return productRepository.findAllByStateTrue().stream()
                .map(ProductResponse::new)
                .toList();
    }

    public List<ProductResponse> searchProducts(String term) {

        return productRepository.searchByNameOrCode(term).stream()
                .map(ProductResponse::new)
                .toList();
    }

    public ProductResponse registerProduct(ProductCreateRequest productCreateRequest) {

        Product product = productCreateRequest.toEntity();
        Supplier supplier = supplierRepository.findById(productCreateRequest.supplierId())
                .filter(Supplier::getState)
                .orElseThrow(() -> new EntityNotFoundException("Supplier not found"));
        product.setSupplier(supplier);
        String code = "PROD-" + UUID.randomUUID().toString().substring(0, 6).toUpperCase();
        product.setCode(code);
        product.setState(true);

        return new ProductResponse(productRepository.save(product));
    }

    public ProductResponse updateProduct(Long id, ProductUpdateRequest productUpdateRequest) {

        Product product = productRepository.findById(id)
                .filter(Product::getState)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        product.setName(productUpdateRequest.name());
        product.setCategory(productUpdateRequest.category());
        product.setPurchasePrice(productUpdateRequest.purchasePrice());
        product.setSalePrice(productUpdateRequest.salePrice());
        product.setStock(productUpdateRequest.stock());

        return new ProductResponse(productRepository.save(product));
    }

    public void deleteProduct(Long id) {

        Product product = productRepository.findById(id)
                .filter(Product::getState)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));

        product.setState(false);
        productRepository.save(product);
    }
}