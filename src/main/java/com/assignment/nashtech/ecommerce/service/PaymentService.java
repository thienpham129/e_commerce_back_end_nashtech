package com.assignment.nashtech.ecommerce.service;

import com.assignment.nashtech.ecommerce.dto.PaymentDTO;
import com.assignment.nashtech.ecommerce.model.Payment;

import java.util.List;
import java.util.Optional;

public interface PaymentService {
    List<Payment> getAllPayments();

    Optional<Payment> getPaymentById(int paymentId);

    Payment savePayment(PaymentDTO paymentDTO);

    Payment updatePaymentById(int paymentId, PaymentDTO paymentDTO);

    void DeletePaymentById(int paymentId);
}
