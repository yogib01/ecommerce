package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.exception.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ProductService {
	private Map<Integer, Product> products = new ConcurrentHashMap<>();


    public Product addProduct(String name, double price, int stock) {
        Product p = new Product(name, price, stock);
        products.put(p.getId(), p);
        return p;
    }

    public Product updateStock(int id, int stock) {
        Product p = products.get(id);
        if (p == null) throw new ProductNotFoundException("Product not found!");
        p.setStockQuantity(stock);
        return p;
    }

    public Product getProductById(int id) {
        Product p = products.get(id);
        if (p == null) throw new ProductNotFoundException("Product with ID " + id + " not found");
        return p;
    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }
}
