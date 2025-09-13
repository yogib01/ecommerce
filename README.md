# Mini E-Commerce Backend System

## Description
This is a simple Java-based e-commerce backend system built using **Spring Boot**.  
It supports product management, cart management, and order management, using **in-memory Java Collections** (no database required).

---

## Features

### Product Management
- Add new products
- Update product stock
- Get product by ID
- List all products

### Cart Management
- Add products to cart (cannot exceed available stock)
- Remove products from cart
- View cart items and total price
- Apply 10% discount if total > ₹10,000

### Order Management
- Place an order (reduces product stock)
- View order details by ID
- Update order status (`PLACED`, `SHIPPED`, `DELIVERED`)

### Additional Features
- Exception handling (product not found, insufficient stock)
- Unit tests using JUnit 5

---

## Technologies Used
- Java 17+
- Spring Boot
- Maven
- JUnit 5 (Unit Testing)

---

1. Clone the repository:
  ```bash
    git clone <your-github-repo-url>
    cd ecommerce
  ```
---
2. Run the Spring Boot application:
```
mvn spring-boot:run
```


The application will start at: http://localhost:8080
---
3. API Endpoints
   
   https://test00-6192.postman.co/workspace/Mini-Ecommerce-Backend-System~f84b84ec-1ab8-40fa-b915-032e91d51dec/collection/40766054-bee82b89-79c2-4e8c-9e77-92bc20a03196?action=share&source=copy-link&creator=40766054
---
Running Unit Tests
  ```
    mvn test
```
---
Notes

All data is stored in-memory using Java Collections.

Cart total > ₹10,000 → 10% discount applied.

Handles exceptions for invalid operations.
