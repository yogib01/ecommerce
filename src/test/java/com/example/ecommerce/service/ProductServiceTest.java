package com.example.ecommerce.service;

import com.example.ecommerce.exception.ProductNotFoundException;
import com.example.ecommerce.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductServiceTest {

    private ProductService productService;

    @BeforeEach
    void setup() {
        productService = new ProductService();
    }

    @Test
    void addProduct_shouldReturnProductWithId() {
        Product p = productService.addProduct("Laptop", 60000, 10);
        assertNotNull(p.getId());
        assertEquals("Laptop", p.getName());
    }

    @Test
    void getProductById_shouldThrowExceptionIfNotFound() {
        assertThrows(ProductNotFoundException.class, () -> productService.getProductById(999));
    }

    @Test
    void updateStock_shouldUpdateCorrectly() {
        Product p = productService.addProduct("Phone", 30000, 5);
        Product updated = productService.updateStock(p.getId(), 10);
        assertEquals(10, updated.getStockQuantity());
    }
}
