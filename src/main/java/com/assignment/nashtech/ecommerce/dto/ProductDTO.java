package com.assignment.nashtech.ecommerce.dto;

import com.assignment.nashtech.ecommerce.model.Category;

public class ProductDTO {
    private String productName;
    private String imageUrl;
    private int price;
    private String description;
    private int quantity;
    private int categoryId;
    private boolean isActive = true;
    private boolean isFeatured = false;

    public ProductDTO() {
    }

    public ProductDTO(String productName, String imageUrl, int price, String description, int quantity, int categoryId, boolean isActive, boolean isFeatured) {
        this.productName = productName;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.isActive = isActive;
        this.isFeatured = isFeatured;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isFeatured() {
        return isFeatured;
    }

    public void setFeatured(boolean featured) {
        isFeatured = featured;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productName='" + productName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", categoryId=" + categoryId +
                ", isActive=" + isActive +
                ", isFeatured=" + isFeatured +
                '}';
    }
}
