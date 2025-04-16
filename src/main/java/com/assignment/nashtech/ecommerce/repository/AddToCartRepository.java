package com.assignment.nashtech.ecommerce.repository;

import com.assignment.nashtech.ecommerce.model.AddToCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddToCartRepository extends JpaRepository<AddToCart, Integer> {
}
