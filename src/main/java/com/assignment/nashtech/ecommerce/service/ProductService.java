package com.assignment.nashtech.ecommerce.service;

import com.assignment.nashtech.ecommerce.dto.ProductDTO;
import com.assignment.nashtech.ecommerce.model.Product;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAllProducts();

    Optional<Product> getProductById(@PathVariable int productId);

    Product saveProduct(ProductDTO productDTO);

    Product updateProductById(int productId, ProductDTO productDTO);

    void deleteProductById(int productId);
}
