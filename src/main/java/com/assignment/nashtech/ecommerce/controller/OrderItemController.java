package com.assignment.nashtech.ecommerce.controller;

import com.assignment.nashtech.ecommerce.dto.OrderDTO;
import com.assignment.nashtech.ecommerce.dto.OrderItemDTO;
import com.assignment.nashtech.ecommerce.model.OrderItem;
import com.assignment.nashtech.ecommerce.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/{orderItems}")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/")
    public List<OrderItem> getAllOrderItems(){
        return orderItemService.getAllOrderItems();
    }

    @GetMapping("/{orderItemId}")
    public Optional<OrderItem> getOrderItemById(@PathVariable int orderItemId){
        return orderItemService.getOrderItemById(orderItemId);
    }

    @PostMapping("/")
    public OrderItem createOrderItem(@RequestBody OrderItemDTO orderItemDTO){
        return orderItemService.saveOrderItem(orderItemDTO);
    }

    @PutMapping("/{orderItemId}")
    public OrderItem updateOrderItemById(@PathVariable int orderItemId, @RequestBody OrderItemDTO orderItemDTO){
        return orderItemService.updateOrderItemById(orderItemId, orderItemDTO);
    }

    @DeleteMapping("/{orderItemId}")
    public void deleteOrderItemById(@PathVariable int orderItemId){
        orderItemService.deleteOrderItemById(orderItemId);
    }
}
