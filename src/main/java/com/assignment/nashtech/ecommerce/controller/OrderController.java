package com.assignment.nashtech.ecommerce.controller;

import com.assignment.nashtech.ecommerce.dto.OrderDTO;
import com.assignment.nashtech.ecommerce.model.Order;
import com.assignment.nashtech.ecommerce.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public Optional<Order> getOrderById(@PathVariable int orderId){
        return orderService.getOrderById(orderId);
    }

    @PostMapping("/")
    public Order createOrder(@RequestBody OrderDTO orderDTO){
        return orderService.saveOrder(orderDTO);
    }

    @PutMapping("/{orderId}")
    public Order updateOrderById(@PathVariable int orderId, @RequestBody OrderDTO orderDTO){
        return orderService.updateOrderById(orderId, orderDTO);
    }

    @DeleteMapping("/{orderId}")
    public void deleteOrderById(@PathVariable int orderId){
        orderService.deleteOrderById(orderId);
    }
}
