package com.assignment.nashtech.ecommerce.service;

import com.assignment.nashtech.ecommerce.dto.OrderDTO;
import com.assignment.nashtech.ecommerce.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAllOrders();

    Optional<Order> getOrderById(int orderId);

    Order saveOrder(OrderDTO orderDTO);

    Order updateOrderById(int orderId, OrderDTO orderDTO);

    void deleteOrderById(int orderId);
}
