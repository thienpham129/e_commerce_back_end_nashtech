package com.assignment.nashtech.ecommerce.repository;

import com.assignment.nashtech.ecommerce.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
