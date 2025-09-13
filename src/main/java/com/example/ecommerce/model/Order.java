package com.example.ecommerce.model;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private static final AtomicInteger counter = new AtomicInteger(1);

    private int orderId;
    private Map<Product, Integer> cartItems;
    private double totalAmount;
    private OrderStatus status;

    public Order(Map<Product, Integer> cartItems, double totalAmount) {
        this.orderId = counter.getAndIncrement();
        this.cartItems = cartItems;
        this.totalAmount = totalAmount;
        this.status = OrderStatus.PLACED; // default status
    }

    public int getOrderId() { return orderId; }
    public Map<Product, Integer> getCartItems() { return cartItems; }
    public double getTotalAmount() { return totalAmount; }
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }
}
