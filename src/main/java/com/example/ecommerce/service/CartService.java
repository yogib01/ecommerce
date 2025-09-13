package com.example.ecommerce.service;

import com.example.ecommerce.exception.InsufficientStockException;
import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.Product;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private Cart cart = new Cart();

    public Cart addToCart(Product product, int qty) {
        if (product.getStockQuantity() < qty) {
            throw new InsufficientStockException("Cannot add " + qty + " items. Only " + product.getStockQuantity() + " in stock.");
        }
        cart.addProduct(product, qty);
        return cart;
    }

    public Cart removeFromCart(Product product) {
        cart.removeProduct(product);
        return cart;
    }

    public Cart viewCart() {
        return cart;
    }
}
