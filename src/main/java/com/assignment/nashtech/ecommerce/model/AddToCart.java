package com.assignment.nashtech.ecommerce.model;

import java.time.LocalDateTime;

public class AddToCart {
    private int add_to_cart;
    private int user_id;
    private int product_id;
    private int quantity;
    private LocalDateTime added_at;

    public AddToCart() {
    }

    public AddToCart(int add_to_cart, int user_id, int product_id, int quantity, LocalDateTime added_at) {
        this.add_to_cart = add_to_cart;
        this.user_id = user_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.added_at = added_at;
    }

    public int getAdd_to_cart() {
        return add_to_cart;
    }

    public void setAdd_to_cart(int add_to_cart) {
        this.add_to_cart = add_to_cart;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getAdded_at() {
        return added_at;
    }

    public void setAdded_at(LocalDateTime added_at) {
        this.added_at = added_at;
    }

    @Override
    public String toString() {
        return "AddToCart{" +
                "add_to_cart=" + add_to_cart +
                ", user_id=" + user_id +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                ", added_at=" + added_at +
                '}';
    }
}
