package com.example.ecommerce.controller;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product addProduct(@RequestParam String name,
                              @RequestParam double price,
                              @RequestParam int stock) {
        return service.addProduct(name, price, stock);
    }

    @PutMapping("/{id}")
    public Product updateStock(@PathVariable int id, @RequestParam int stock) {
        return service.updateStock(id, stock);
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping
    public Collection<Product> getAll() {
        return service.getAllProducts();
    }
}
