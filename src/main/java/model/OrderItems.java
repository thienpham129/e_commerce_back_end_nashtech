package model;

import java.time.LocalDateTime;

public class OrderItems {
    private int order_items_id;
    private int order_id;
    private int product_id;
    private int quantity;
    private double price;
    private LocalDateTime created_at;

    public OrderItems() {
    }

    public OrderItems(int order_items_id, int order_id, int product_id, int quantity, double price, LocalDateTime created_at) {
        this.order_items_id = order_items_id;
        this.order_id = order_id;
        this.product_id = product_id;
        this.quantity = quantity;
        this.price = price;
        this.created_at = created_at;
    }

    public int getOrder_items_id() {
        return order_items_id;
    }

    public void setOrder_items_id(int order_items_id) {
        this.order_items_id = order_items_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "OrderItems{" +
                "order_items_id=" + order_items_id +
                ", order_id=" + order_id +
                ", product_id=" + product_id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", created_at=" + created_at +
                '}';
    }
}
