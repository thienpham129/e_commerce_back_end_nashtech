package com.assignment.nashtech.ecommerce.controller;

import com.assignment.nashtech.ecommerce.dto.AddToCartDTO;
import com.assignment.nashtech.ecommerce.model.AddToCart;
import com.assignment.nashtech.ecommerce.service.AddToCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addToCarts")
public class AddToCartController {
    @Autowired
    private AddToCartService addToCartService;

    @GetMapping("/")
    public List<AddToCart> getAllAddToCarts(){
        return addToCartService.getAllAddToCart();
    }

    @GetMapping("/{addToCartId}")
    public Optional<AddToCart> getAddToCartById(@PathVariable int addToCartId){
        return addToCartService.getAddToCartById(addToCartId);
    }

    @PostMapping("/")
    public AddToCart createAddToCart(@RequestBody AddToCartDTO addToCartDTO){
        return addToCartService.saveAddToCart(addToCartDTO);
    }

    @PutMapping("/{addToCartId}")
    public AddToCart updateAddToCartById(@PathVariable int addToCartId, @RequestBody AddToCartDTO addToCartDTO){
        return addToCartService.updateAddToCartById(addToCartId, addToCartDTO);
    }

    @DeleteMapping("/{addToCartId}")
    public void deleteAddToCartById(@PathVariable int addToCartId){
        addToCartService.deleteAddToCartById(addToCartId);
    }
}
