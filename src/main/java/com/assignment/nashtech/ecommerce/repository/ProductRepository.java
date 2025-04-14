package com.assignment.nashtech.ecommerce.repository;

import com.assignment.nashtech.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
