package com.assignment.nashtech.ecommerce.implement;

import com.assignment.nashtech.ecommerce.dto.ProductDTO;
import com.assignment.nashtech.ecommerce.model.Category;
import com.assignment.nashtech.ecommerce.model.Product;
import com.assignment.nashtech.ecommerce.repository.CategoryRepository;
import com.assignment.nashtech.ecommerce.repository.ProductRepository;
import com.assignment.nashtech.ecommerce.repository.ReviewRepository;
import com.assignment.nashtech.ecommerce.response.ProductResponseDto;
import com.assignment.nashtech.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private final ProductRepository productRepository;

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private final ReviewRepository reviewRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ReviewRepository reviewRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Page<ProductResponseDto> getAllProducts(int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("CreatedAt").descending());
        Page<Product> productPage = productRepository.findAll(pageable);

        return productPage.map(ProductResponseDto::new);
    }

    @Override
    public Optional<Product> getProductById(int productId) {
        return productRepository.findById(productId);
    }

    @Override
    public List<Product> getProductByCategoryId(int categoryId) {
        return productRepository.findByCategoryCategoryId(categoryId);
    }

    @Override
    public List<Product> getFeaturedProducts() {
        return productRepository.findByIsFeaturedTrue();
    }

    @Override
    public Map<Integer, Double> getAverageRatings(){
        List<Object[]> results = reviewRepository.findAverageRatingForProducts();
        Map<Integer, Double> averageRatings = new HashMap<>();

        for (Object[] result: results){
            Integer productId = (Integer) result[0];
            Double averageRating = (Double) result[1];
            averageRatings.put(productId, averageRating);
        }

        return averageRatings;
    }

    @Override
    public Double getAverageRatingByProductId(Integer productId){
        Double rating = reviewRepository.findAverageRatingsByProductId(productId);
        return rating != null ? rating : 0.0;
    }

    @Override
    public List<Product> saveAllProducts(List<ProductDTO> productDTOs) {
        List<Product> products = new ArrayList<>();

        for (ProductDTO productDTO : productDTOs) {

            Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not Found"));

            Product product = new Product();
            product.setProductName((productDTO.getProductName()));
            product.setImageUrl(productDTO.getImageUrl());
            product.setPrice(productDTO.getPrice());
            product.setDescription(productDTO.getDescription());
            product.setQuantity(productDTO.getQuantity());
            product.setCategory(category);
            product.setActive(productDTO.isActive());
            product.setFeatured(productDTO.isFeatured());

            products.add(product);
        }

        return productRepository.saveAll(products);
    }

    @Override
    public Product saveProduct(ProductDTO productDTO) {
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not Found"));

        Product product = new Product();
        product.setProductName((productDTO.getProductName()));
        product.setImageUrl(productDTO.getImageUrl());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setQuantity(productDTO.getQuantity());
        product.setCategory(category);
        product.setActive(productDTO.isActive());
        product.setFeatured(productDTO.isFeatured());

        return productRepository.save(product);
    }

    @Override
    public Product updateProductById(int productId, ProductDTO productDTO) {
        Optional<Product> productExisting = productRepository.findById(productId);
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found"));
        if (productExisting.isPresent()) {
            Product p = productExisting.get();
            p.setProductName(productDTO.getProductName());
            p.setImageUrl(productDTO.getImageUrl());
            p.setPrice(productDTO.getPrice());
            p.setDescription(productDTO.getDescription());
            p.setQuantity(productDTO.getQuantity());
            p.setCategory(category);
            p.setActive(productDTO.isActive());
            p.setFeatured(productDTO.isFeatured());
            return productRepository.save(p);
        }
        return null;
    }

    @Override
    public void deleteProductById(int productId) {
        productRepository.deleteById(productId);
    }
}
