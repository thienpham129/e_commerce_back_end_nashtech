package com.assignment.nashtech.ecommerce.repository;

import com.assignment.nashtech.ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
