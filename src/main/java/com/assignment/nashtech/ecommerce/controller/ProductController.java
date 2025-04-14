package com.assignment.nashtech.ecommerce.controller;

import com.assignment.nashtech.ecommerce.dto.ProductDTO;
import com.assignment.nashtech.ecommerce.model.Product;
import com.assignment.nashtech.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<Product> getAllProduct(){
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Optional<Product> getProductById(@PathVariable int productId){
        return productService.getProductById(productId);
    }

    @PostMapping("/")
    public Product createProduct(@RequestBody ProductDTO productDTO){
        return productService.saveProduct(productDTO);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@RequestBody ProductDTO productDTO, @PathVariable int productId){
        return productService.updateProductById(productId, productDTO);
    }

    @DeleteMapping("/{productId}")
    public void deleteProductById(@PathVariable int productId){
        productService.deleteProductById(productId);
    }
}
