package com.example.ecommerce.service;

import com.example.ecommerce.exception.InsufficientStockException;
import com.example.ecommerce.model.Cart;
import com.example.ecommerce.model.Order;
import com.example.ecommerce.model.OrderStatus;
import com.example.ecommerce.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {

    private ProductService productService;
    private CartService cartService;
    private OrderService orderService;

    @BeforeEach
    void setup() {
        productService = new ProductService();
        cartService = new CartService();
        orderService = new OrderService();
    }

    @Test
    void placeOrder_shouldReduceStockAndCreateOrder() {
        // Create a product
        Product p = productService.addProduct("Laptop", 60000, 5);

        // Add product to cart
        cartService.addToCart(p, 2);

        // Get the current cart
        Cart cart = cartService.viewCart();  //  cart is defined here

        // Place the order
        Order order = orderService.placeOrder(cart);

        // Assertions
        assertEquals(2, order.getCartItems().get(p));
        assertEquals(3, p.getStockQuantity()); // stock reduced
        assertEquals(OrderStatus.PLACED, order.getStatus());
    }

    @Test
    void placeOrder_shouldThrowIfInsufficientStock() {
        Product p = productService.addProduct("Laptop", 60000, 1);

        // Try to add more than available stock
        assertThrows(InsufficientStockException.class, () -> cartService.addToCart(p, 2));
    }

    @Test
    void updateStatus_shouldChangeOrderStatus() {
        Product p = productService.addProduct("Laptop", 60000, 5);
        cartService.addToCart(p, 1);
        Cart cart = cartService.viewCart();

        Order order = orderService.placeOrder(cart);

        // Update status
        orderService.updateStatus(order.getOrderId(), OrderStatus.SHIPPED);

        assertEquals(OrderStatus.SHIPPED, order.getStatus());
    }

    @Test
    void getOrderById_shouldReturnCorrectOrder() {
        Product p = productService.addProduct("Laptop", 60000, 5);
        cartService.addToCart(p, 1);
        Cart cart = cartService.viewCart();

        Order order = orderService.placeOrder(cart);

        Order fetchedOrder = orderService.getOrderById(order.getOrderId());

        assertEquals(order.getOrderId(), fetchedOrder.getOrderId());
        assertEquals(order.getCartItems().size(), fetchedOrder.getCartItems().size());
    }
}
