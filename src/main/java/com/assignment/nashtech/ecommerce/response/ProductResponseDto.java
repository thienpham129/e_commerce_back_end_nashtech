package com.assignment.nashtech.ecommerce.response;

import com.assignment.nashtech.ecommerce.model.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
    private int id;
    private String productName;
    private String imageUrl;
    private int price;
    private int quantity;

    public ProductResponseDto(Product product) {
        this.id = product.getProductId();
        this.productName = product.getProductName();
        this.imageUrl = product.getImageUrl();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
    }
}
