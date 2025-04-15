package com.assignment.nashtech.ecommerce.implement;

import com.assignment.nashtech.ecommerce.dto.OrderDTO;
import com.assignment.nashtech.ecommerce.model.Order;
import com.assignment.nashtech.ecommerce.model.User;
import com.assignment.nashtech.ecommerce.repository.OrderRepository;
import com.assignment.nashtech.ecommerce.repository.UserRepository;
import com.assignment.nashtech.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(int orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public Order saveOrder(OrderDTO orderDTO) {
        User user = userRepository.findById(orderDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not Found"));

        Order order = new Order();
        order.setUser(user);
        order.setOrderStatus(orderDTO.getOrderStatus());
        order.setTotalAmount(orderDTO.getTotalAmount());
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrderById(int orderId, OrderDTO orderDTO) {
        Optional<Order> orderExisting = orderRepository.findById(orderId);
        User user = userRepository.findById(orderDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not Found"));
        if (orderExisting.isPresent()) {
            Order o = orderExisting.get();
            o.setUser(user);
            o.setTotalAmount(orderDTO.getTotalAmount());
            o.setOrderStatus(orderDTO.getOrderStatus());
            return orderRepository.save(o);
        }
        return null;
    }

    @Override
    public void deleteOrderById(int orderId) {
        orderRepository.deleteById(orderId);
    }
}
