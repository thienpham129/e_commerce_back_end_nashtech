package model;

import java.time.LocalDateTime;

public class Products {
    private int product_id;
    private String product_name;
    private String image_url;
    private int price;
    private String description;
    private int quantity;
    private boolean is_active;
    private LocalDateTime created_at;
    private LocalDateTime update_at;

    public Products() {
    }

    public Products(int product_id, String product_name, String image_url, int price, String description, int quantity, boolean is_active, LocalDateTime created_at, LocalDateTime update_at) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.image_url = image_url;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.is_active = is_active;
        this.created_at = created_at;
        this.update_at = update_at;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
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

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(LocalDateTime update_at) {
        this.update_at = update_at;
    }

    @Override
    public String toString() {
        return "Products{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", image_url='" + image_url + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", is_active=" + is_active +
                ", created_at=" + created_at +
                ", update_at=" + update_at +
                '}';
    }
}
