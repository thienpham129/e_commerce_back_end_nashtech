package com.assignment.nashtech.ecommerce.repository;

import com.assignment.nashtech.ecommerce.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
