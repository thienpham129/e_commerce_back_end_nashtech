package com.assignment.nashtech.ecommerce.dto;

public class AddToCartDTO {
    private int AddToCartId;
    private int userId;
    private int productId;
    private int quantity;

    public AddToCartDTO() {
    }

    public AddToCartDTO(int addToCartId, int userId, int productId, int quantity) {
        AddToCartId = addToCartId;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getAddToCartId() {
        return AddToCartId;
    }

    public void setAddToCartId(int addToCartId) {
        AddToCartId = addToCartId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "AddToCartDTO{" +
                "AddToCartId=" + AddToCartId +
                ", userId=" + userId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}
