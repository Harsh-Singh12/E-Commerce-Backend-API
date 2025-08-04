# 🛒 E-Commerce-Backend-API

A robust and secure backend REST API for an e-commerce application built using Spring Boot. Supports user authentication, product management, cart/wishlist handling with Redis, order placement, and dummy payment simulation.

---

## 📦 Features

- **🔐 User Registration & Login with JWT**  
  Allows users to securely register and log in. Issues JWT tokens for protected access.

- **🛡️ Role-Based Auth & Protected APIs**  
  Secures endpoints using Spring Security and JWT. Only authenticated users can access protected resources.

- **📦 CRUD for Products & Categories**  
  Admin users can create, update, delete, and list products and categories.

- **🛒 Cart & Wishlist with Redis**  
  Users can manage cart and wishlist efficiently using Redis for fast in-memory access.

- **📦 Order Placement**  
  Users can place orders for items in their cart. Orders are persisted and can be viewed later.

- **💳 Dummy Payment Integration**  
  Simulates payment flow for testing order checkout without real payment gateway integration.

---

## 🛠️ Tech Stack

- **Framework:** Spring Boot (3.4+), Spring Security, Spring Data JPA  
- **Database:** MySQL for persistent storage  
- **Cache:** Redis for cart and wishlist  
- **Auth:** JWT (JSON Web Token) for secure authentication  
- **Tools:** Maven, Lombok, Postman for API testing and documentation

---

## 🚀 Getting Started

To run this project locally:

```bash
git clone https://github.com/Harsh-Singh12/E-Commerce-Backend-API.git
cd E-Commerce-Backend-API
./mvnw spring-boot:run

