package com.startcoding0to1.shopeasybackend.dto;

import com.startcoding0to1.shopeasybackend.entity.Cart;
import com.startcoding0to1.shopeasybackend.entity.Product;
import com.startcoding0to1.shopeasybackend.entity.User;
import java.time.LocalDateTime;
import java.util.Objects;

public class CartDTO {
    private Integer cartId;
    private User user;
    private Product product;
    private Integer quantity;
    private LocalDateTime creationTime;

    public CartDTO(Integer cartId, User user, Product product, Integer quantity, LocalDateTime creationTime) {
        this.cartId = cartId;
        this.user = user;
        this.product = product;
        this.quantity = quantity;
        this.creationTime = creationTime;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(getCartId(), cart.getCartId()) && Objects.equals(getUser(), cart.getUser()) && Objects.equals(getProduct(), cart.getProduct()) && Objects.equals(getQuantity(), cart.getQuantity()) && Objects.equals(getCreationTime(), cart.getCreationTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCartId(), getUser(), getProduct(), getQuantity(), getCreationTime());
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", user=" + user +
                ", product=" + product +
                ", quantity=" + quantity +
                ", cretionTime=" + creationTime +
                '}';
    }
}
