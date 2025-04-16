package com.assignment.nashtech.ecommerce.repository;

import com.assignment.nashtech.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategoryCategoryId(int categoryId);
}
