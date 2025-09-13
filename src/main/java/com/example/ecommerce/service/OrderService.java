package com.example.ecommerce.service;

import com.example.ecommerce.model.*;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class OrderService {
    private Map<Integer, Order> orders = new ConcurrentHashMap<>();

    public Order placeOrder(Cart cart) {
        // Reduce stock
        cart.getItems().forEach((p, q) -> p.setStockQuantity(p.getStockQuantity() - q));

        Order order = new Order(cart.getItems(), cart.getTotalPrice());
        orders.put(order.getOrderId(), order);

        // Clear cart after placing order
        cart.getItems().clear();

        return order;
    }

    public Order getOrderById(int id) {
        return orders.get(id);
    }

    public Order updateStatus(int id, OrderStatus status) {
        Order order = orders.get(id);
        if (order != null) {
            order.setStatus(status);
        }
        return order;
    }
}
