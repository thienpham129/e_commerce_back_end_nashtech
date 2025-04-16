package com.assignment.nashtech.ecommerce.controller;

import com.assignment.nashtech.ecommerce.dto.PaymentDTO;
import com.assignment.nashtech.ecommerce.model.Payment;
import com.assignment.nashtech.ecommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/")
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{paymentId}")
    public Optional<Payment> getPaymentById(@PathVariable int paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @PostMapping("/")
    public Payment createPayment(@RequestBody PaymentDTO paymentDTO) {
        return paymentService.savePayment(paymentDTO);
    }

    @PutMapping("/{paymentId}")
    public Payment updatePaymentById(@PathVariable int paymentId, @RequestBody PaymentDTO paymentDTO) {
        return paymentService.updatePaymentById(paymentId, paymentDTO);
    }

    public void deletePaymentById(@PathVariable int paymentId) {
        paymentService.DeletePaymentById(paymentId);
    }
}
