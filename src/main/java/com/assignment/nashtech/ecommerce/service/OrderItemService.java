package com.assignment.nashtech.ecommerce.service;

import com.assignment.nashtech.ecommerce.dto.OrderItemDTO;
import com.assignment.nashtech.ecommerce.model.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderItemService {
    List<OrderItem> getAllOrderItems();

    Optional<OrderItem> getOrderItemById(int orderId);

    OrderItem saveOrderItem(OrderItemDTO orderItemDTO);

    OrderItem updateOrderItemById(int orderItemId, OrderItemDTO orderItemDTO);

    void deleteOrderItemById(int orderItemId);
}
