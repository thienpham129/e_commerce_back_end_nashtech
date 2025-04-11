package com.assignment.nashtech.ecommerce.model;

import java.time.LocalDateTime;

public class Orders {
    private int order_id;
    private int user_id;
    private LocalDateTime order_date;
    private double total_amount;
    private String status;
    private LocalDateTime updated_at;

    public Orders() {
    }

    public Orders(int order_id, int user_id, LocalDateTime order_date, double total_amount, String status, LocalDateTime updated_at) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.order_date = order_date;
        this.total_amount = total_amount;
        this.status = status;
        this.updated_at = updated_at;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public LocalDateTime getOrder_date() {
        return order_date;
    }

    public void setOrder_date(LocalDateTime order_date) {
        this.order_date = order_date;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", order_date=" + order_date +
                ", total_amount=" + total_amount +
                ", status='" + status + '\'' +
                ", updated_at=" + updated_at +
                '}';
    }
}
