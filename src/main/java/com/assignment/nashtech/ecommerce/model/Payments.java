package com.assignment.nashtech.ecommerce.model;

import java.time.LocalDateTime;

public class Payments {
    private int payment_id;
    private int order_id;
    private String payment_method;
    private String payment_status;
    private LocalDateTime paid_at;

    public Payments() {
    }

    public Payments(int payment_id, int order_id, String payment_method, String payment_status, LocalDateTime paid_at) {
        this.payment_id = payment_id;
        this.order_id = order_id;
        this.payment_method = payment_method;
        this.payment_status = payment_status;
        this.paid_at = paid_at;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(String payment_status) {
        this.payment_status = payment_status;
    }

    public LocalDateTime getPaid_at() {
        return paid_at;
    }

    public void setPaid_at(LocalDateTime paid_at) {
        this.paid_at = paid_at;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "payment_id=" + payment_id +
                ", order_id=" + order_id +
                ", payment_method='" + payment_method + '\'' +
                ", payment_status='" + payment_status + '\'' +
                ", paid_at=" + paid_at +
                '}';
    }
}
