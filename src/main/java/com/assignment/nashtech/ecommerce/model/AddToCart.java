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
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    public AddToCart() {
    }

    public AddToCart(int addToCartId, User user, Product product, int quantity) {
        this.addToCartId = addToCartId;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
    }

    public int getAddToCartId() {
        return addToCartId;
    }

    public void setAddToCartId(int addToCartId) {
        this.addToCartId = addToCartId;
    }

    public @NotNull User getUser() {
        return user;
    }

    public void setUser(@NotNull User user) {
        this.user = user;
    }

    public @NotNull Product getProduct() {
        return product;
    }

    public void setProduct(@NotNull Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "AddToCart{" +
                "addToCartId=" + addToCartId +
                ", user=" + user +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
