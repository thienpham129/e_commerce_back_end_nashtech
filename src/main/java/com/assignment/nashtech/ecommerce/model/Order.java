package com.assignment.nashtech.ecommerce.model;

import com.assignment.nashtech.ecommerce.enums.OrderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;


    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "order_date", updatable = false)
    @CreationTimestamp
    private LocalDateTime orderDate;

    @Column(name = "total_amount")
    private double totalAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "orderStatus")
    private OrderStatus orderStatus;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> orderOrderItems = new ArrayList<>();

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Payment> orderPayments = new ArrayList<>();

    public Order() {
    }

    public Order(int orderId, User user, LocalDateTime orderDate, double totalAmount, OrderStatus orderStatus, LocalDateTime updatedAt) {
        this.orderId = orderId;
        this.user = user;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
        this.updatedAt = updatedAt;
    }

    public Order(int orderId, User user, LocalDateTime orderDate, double totalAmount, OrderStatus orderStatus, LocalDateTime updatedAt, List<OrderItem> orderOrderItems, List<Payment> orderPayments) {
        this.orderId = orderId;
        this.user = user;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
        this.updatedAt = updatedAt;
        this.orderOrderItems = orderOrderItems;
        this.orderPayments = orderPayments;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public @NotNull User getUser() {
        return user;
    }

    public void setUser(@NotNull User user) {
        this.user = user;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<OrderItem> getOrderOrderItems() {
        return orderOrderItems;
    }

    public void setOrderOrderItems(List<OrderItem> orderOrderItems) {
        this.orderOrderItems = orderOrderItems;
    }

    public List<Payment> getOrderPayments() {
        return orderPayments;
    }

    public void setOrderPayments(List<Payment> orderPayments) {
        this.orderPayments = orderPayments;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", user=" + user +
                ", orderDate=" + orderDate +
                ", totalAmount=" + totalAmount +
                ", orderStatus=" + orderStatus +
                ", updatedAt=" + updatedAt +
                ", orderOrderItems=" + orderOrderItems +
                ", orderPayments=" + orderPayments +
                '}';
    }
}
