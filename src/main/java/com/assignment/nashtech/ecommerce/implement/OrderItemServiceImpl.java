package com.assignment.nashtech.ecommerce.implement;

import com.assignment.nashtech.ecommerce.dto.OrderItemDTO;
import com.assignment.nashtech.ecommerce.model.Order;
import com.assignment.nashtech.ecommerce.model.OrderItem;
import com.assignment.nashtech.ecommerce.model.Product;
import com.assignment.nashtech.ecommerce.repository.OrderItemRepository;
import com.assignment.nashtech.ecommerce.repository.OrderRepository;
import com.assignment.nashtech.ecommerce.repository.ProductRepository;
import com.assignment.nashtech.ecommerce.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public Optional<OrderItem> getOrderItemById(int orderItemId) {
        return orderItemRepository.findById(orderItemId);
    }

    @Override
    public OrderItem saveOrderItem(OrderItemDTO orderItemDTO) {
        Order order = orderRepository.findById(orderItemDTO.getOrderId()).orElseThrow(() -> new RuntimeException("Order not Found"));
        Product product = productRepository.findById(orderItemDTO.getProductId()).orElseThrow(() -> new RuntimeException("Product not Found"));

        OrderItem orderItem = new OrderItem();
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItem.setPrice(orderItemDTO.getPrice());
        orderItem.setQuantity(orderItemDTO.getQuantity());

        return orderItemRepository.save(orderItem);
    }

    @Override
    public OrderItem updateOrderItemById(int orderItemId, OrderItemDTO orderItemDTO) {
        Optional<OrderItem> orderItemExisting = orderItemRepository.findById(orderItemId);
        Order order = orderRepository.findById(orderItemDTO.getOrderId()).orElseThrow(() -> new RuntimeException("Order not Found"));
        Product product = productRepository.findById(orderItemDTO.getProductId()).orElseThrow(() -> new RuntimeException("Product not Found"));

        if (orderItemExisting.isPresent()) {
            OrderItem orderItem = orderItemExisting.get();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setPrice(orderItemDTO.getPrice());
            orderItem.setQuantity(orderItemDTO.getQuantity());
            return orderItemRepository.save(orderItem);
        }
        return null;
    }

    @Override
    public void deleteOrderItemById(int orderItemId) {
        orderItemRepository.deleteById(orderItemId);
    }
}
