package com.assignment.nashtech.ecommerce.implement;

import com.assignment.nashtech.ecommerce.dto.PaymentDTO;
import com.assignment.nashtech.ecommerce.model.Order;
import com.assignment.nashtech.ecommerce.model.Payment;
import com.assignment.nashtech.ecommerce.repository.OrderRepository;
import com.assignment.nashtech.ecommerce.repository.PaymentRepository;
import com.assignment.nashtech.ecommerce.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> getPaymentById(int paymentId) {
        return paymentRepository.findById(paymentId);
    }

    @Override
    public Payment savePayment(PaymentDTO paymentDTO) {
        Order order = orderRepository.findById(paymentDTO.getOrderId()).orElseThrow(() -> new RuntimeException("Order Not Found"));
        Payment payment = new Payment();

        payment.setOrder(order);
        payment.setPaymentMethod(paymentDTO.getPaymentMethod());
        payment.setPaymentStatus(paymentDTO.getPaymentStatus());

        return paymentRepository.save(payment);
    }

    @Override
    public Payment updatePaymentById(int paymentId, PaymentDTO paymentDTO) {
        Optional<Payment> paymentExisting = paymentRepository.findById(paymentId);
        Order order = orderRepository.findById(paymentDTO.getOrderId()).orElseThrow(() -> new RuntimeException("Order not Found"));

        if (paymentExisting.isPresent()) {
            Payment payment = paymentExisting.get();
            payment.setOrder(order);
            payment.setPaymentStatus(paymentDTO.getPaymentStatus());
            payment.setPaymentMethod(paymentDTO.getPaymentMethod());
            return paymentRepository.save(payment);
        }
        return null;
    }

    @Override
    public void DeletePaymentById(int paymentId){
        paymentRepository.deleteById(paymentId);
    }
}
