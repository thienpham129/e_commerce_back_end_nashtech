package com.assignment.nashtech.ecommerce.dto;

import com.assignment.nashtech.ecommerce.enums.PaymentMethod;
import com.assignment.nashtech.ecommerce.enums.PaymentStatus;

public class PaymentDTO {
    private int paymentId;
    private int orderId;
    private PaymentMethod paymentMethod;
    private PaymentStatus paymentStatus;

    public PaymentDTO() {
    }

    public PaymentDTO(int paymentId, int orderId, PaymentMethod paymentMethod, PaymentStatus paymentStatus) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "paymentId=" + paymentId +
                ", orderId=" + orderId +
                ", paymentMethod=" + paymentMethod +
                ", paymentStatus=" + paymentStatus +
                '}';
    }
}
