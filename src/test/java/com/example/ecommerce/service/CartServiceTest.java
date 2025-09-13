package com.example.ecommerce.service;

import com.example.ecommerce.exception.InsufficientStockException;
import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CartServiceTest {

    private CartService cartService;
    private ProductService productService;

    @BeforeEach
    void setup() {
        productService = new ProductService();
        cartService = new CartService();
    }

    @Test
    void addToCart_shouldAddProduct() {
        Product p = productService.addProduct("Laptop", 60000, 5);
        Cart cart = cartService.addToCart(p, 2);
        assertEquals(2, cart.getItems().get(p));
    }

    @Test
    void addToCart_shouldThrowIfInsufficientStock() {
        Product p = productService.addProduct("Laptop", 60000, 1);
        assertThrows(InsufficientStockException.class, () -> cartService.addToCart(p, 2));
    }

    @Test
    void removeFromCart_shouldRemoveProduct() {
        Product p = productService.addProduct("Laptop", 60000, 5);
        cartService.addToCart(p, 2);
        Cart cart = cartService.removeFromCart(p);
        assertFalse(cart.getItems().containsKey(p));
    }
}
