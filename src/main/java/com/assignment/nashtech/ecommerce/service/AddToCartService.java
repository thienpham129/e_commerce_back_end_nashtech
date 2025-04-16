package com.assignment.nashtech.ecommerce.service;

import com.assignment.nashtech.ecommerce.dto.AddToCartDTO;
import com.assignment.nashtech.ecommerce.model.AddToCart;

import java.util.List;
import java.util.Optional;

public interface AddToCartService {
    List<AddToCart> getAllAddToCart();

    Optional<AddToCart> getAddToCartById(int addToCardId);

    AddToCart saveAddToCart(AddToCartDTO addToCartDTO);

    AddToCart updateAddToCartById(int addToCartId, AddToCartDTO addToCartDTO);

    void deleteAddToCartById(int addToCartId);
}
