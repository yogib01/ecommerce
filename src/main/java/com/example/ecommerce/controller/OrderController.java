package com.example.ecommerce.controller;

import com.example.ecommerce.model.*;
import com.example.ecommerce.service.CartService;
import com.example.ecommerce.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final CartService cartService;

    public OrderController(OrderService orderService, CartService cartService) {
        this.orderService = orderService;
        this.cartService = cartService;
    }

    @PostMapping("/place")
    public Order placeOrder() {
        Cart cart = cartService.viewCart();
        return orderService.placeOrder(cart);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id) {
        return orderService.getOrderById(id);
    }

    @PutMapping("/{id}")
    public Order updateStatus(@PathVariable int id, @RequestParam OrderStatus status) {
        return orderService.updateStatus(id, status);
    }
}
