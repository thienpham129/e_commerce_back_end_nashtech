package com.assignment.nashtech.ecommerce.controller;

import com.assignment.nashtech.ecommerce.dto.ProductDTO;
import com.assignment.nashtech.ecommerce.model.Product;
import com.assignment.nashtech.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Optional<Product> getProductById(@PathVariable int productId) {
        return productService.getProductById(productId);
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getProductByCategoryId(@PathVariable int categoryId) {
        return productService.getProductByCategoryId(categoryId);
    }

    @GetMapping("/featured")
    public List<Product> getFeaturedProducts() {
        return productService.getFeaturedProducts();
    }

    @GetMapping("/averageRatings")
    public Map<Integer, Double> getAverageRatings() {
        return productService.getAverageRatings();
    }

    @GetMapping("/averageRatings/{productId}")
    public Double getAverageRatingByProductId(@PathVariable int productId) {
        return productService.getAverageRatingByProductId(productId);
    }

    @PostMapping("/")
    public Product createProduct(@RequestBody ProductDTO productDTO) {
        return productService.saveProduct(productDTO);
    }

    @PostMapping("/saveAllProducts")
    public List<Product> createMultipleProducts(@RequestBody List<ProductDTO> productDTOS) {
        return productService.saveAllProducts(productDTOS);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@RequestBody ProductDTO productDTO, @PathVariable int productId) {
        return productService.updateProductById(productId, productDTO);
    }

    @DeleteMapping("/{productId}")
    public void deleteProductById(@PathVariable int productId) {
        productService.deleteProductById(productId);
    }
}
