package com.example.ecommerce.controller;

import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.CartService;
import com.example.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;
    private final ProductService productService;

    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @PostMapping("/add")
    public Cart addToCart(@RequestParam int productId, @RequestParam int qty) {
        Product p = productService.getProductById(productId);
        return cartService.addToCart(p, qty);
    }

    @DeleteMapping("/remove/{productId}")
    public Cart removeFromCart(@PathVariable int productId) {
        Product p = productService.getProductById(productId);
        return cartService.removeFromCart(p);
    }

    @GetMapping
    public Cart viewCart() {
        return cartService.viewCart();
    }
}
