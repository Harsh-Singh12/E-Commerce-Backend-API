package com.ecommerce.backend.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Date orderDate;

    @ElementCollection
    private List<Long> productIds;

    // Default constructor
    public Order() {
    }

    // All-args constructor
    public Order(Long id, Long userId, Date orderDate, List<Long> productIds) {
        this.id = id;
        this.userId = userId;
        this.orderDate = orderDate;
        this.productIds = productIds;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }
}
