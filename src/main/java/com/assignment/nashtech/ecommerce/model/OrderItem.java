package com.assignment.nashtech.ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "OrderItems")
public class OrderItem {

    @Id
    @GeneratedValue
    private int orderItemsId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private int orderId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private int productId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private double price;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;


    public OrderItem() {
    }

    public OrderItem(int orderItemsId, int orderId, int productId, int quantity, double price, LocalDateTime createdAt) {
        this.orderItemsId = orderItemsId;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.createdAt = createdAt;
    }

    public int getOrderItemsId() {
        return orderItemsId;
    }

    public void setOrderItemsId(int orderItemsId) {
        this.orderItemsId = orderItemsId;
    }

    @NotNull
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(@NotNull int orderId) {
        this.orderId = orderId;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderItemsId=" + orderItemsId +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", createdAt=" + createdAt +
                '}';
    }
}
