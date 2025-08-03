package com.ecommerce.backend.dto;

public class CartItemDTO {
    private Long productId;
    private int quantity;

    // Default constructor
    public CartItemDTO() {
    }

    // All-args constructor
    public CartItemDTO(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
