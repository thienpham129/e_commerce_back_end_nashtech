package com.assignment.nashtech.ecommerce.controller;

import com.assignment.nashtech.ecommerce.dto.ProductDTO;
import com.assignment.nashtech.ecommerce.model.Product;
import com.assignment.nashtech.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/public")
    public List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    @GetMapping("/public/{productId}")
    public Optional<Product> getProductById(@PathVariable int productId) {
        return productService.getProductById(productId);
    }

    @GetMapping("/public/category/{categoryId}")
    public List<Product> getProductByCategoryId(@PathVariable int categoryId) {
        return productService.getProductByCategoryId(categoryId);
    }

    @GetMapping("/public/featured")
    public List<Product> getFeaturedProducts() {
        return productService.getFeaturedProducts();
    }

    @GetMapping("/public/averageRatings")
    public Map<Integer, Double> getAverageRatings() {
        return productService.getAverageRatings();
    }

    @GetMapping("/public/averageRatings/{productId}")
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
