package com.assignment.nashtech.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "AddToCarts")
public class AddToCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addToCartId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private int userId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private int productId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "added_at")
    private LocalDateTime addedAt;

    public AddToCart() {
    }

    public AddToCart(int addToCartId, int userId, int productId, int quantity, LocalDateTime addedAt) {
        this.addToCartId = addToCartId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.addedAt = addedAt;
    }

    public int getAddToCartId() {
        return addToCartId;
    }

    public void setAddToCartId(int addToCartId) {
        this.addToCartId = addToCartId;
    }

    @NotNull
    public int getUserId() {
        return userId;
    }

    public void setUserId(@NotNull int userId) {
        this.userId = userId;
    }

    @NotNull
    public int getProductId() {
        return productId;
    }

    public void setProductId(@NotNull int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(LocalDateTime addedAt) {
        this.addedAt = addedAt;
    }

    @Override
    public String toString() {
        return "AddToCart{" +
                "addToCartId=" + addToCartId +
                ", userId=" + userId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", addedAt=" + addedAt +
                '}';
    }
}
