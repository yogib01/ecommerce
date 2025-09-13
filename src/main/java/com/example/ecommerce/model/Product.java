package com.example.ecommerce.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Product {
    private static final AtomicInteger counter = new AtomicInteger(1);

    private int id;
    private String name;
    private double price;
    private int stockQuantity;

    public Product(String name, double price, int stockQuantity) {
        this.id = counter.getAndIncrement();
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }
}
