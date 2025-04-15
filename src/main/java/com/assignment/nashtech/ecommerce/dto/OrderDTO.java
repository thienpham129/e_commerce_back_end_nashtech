package com.assignment.nashtech.ecommerce.dto;

import com.assignment.nashtech.ecommerce.enums.OrderStatus;

import java.time.LocalDateTime;

public class OrderDTO {
    private int orderId;
    private int userId;
    private double totalAmount;
    private OrderStatus orderStatus;

    public OrderDTO() {
    }

    public OrderDTO(int orderId, int userId, double totalAmount, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", totalAmount=" + totalAmount +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
