package com.startcoding0to1.shopeasybackend.dto;

import com.startcoding0to1.shopeasybackend.entity.Product;
import com.startcoding0to1.shopeasybackend.entity.User;
import com.startcoding0to1.shopeasybackend.entity.Wishlist;

import java.time.LocalDateTime;
import java.util.Objects;

public class WishlistDTO {
    private Integer wishlistId;
    private Product productId;
    private User userId;
    private boolean isLiked;
    private LocalDateTime creationTime;

    public Integer getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(Integer wishlistId) {
        this.wishlistId = wishlistId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
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
        Wishlist wishlist = (Wishlist) o;
        return isLiked() == wishlist.isLiked() && Objects.equals(getWishlistId(), wishlist.getWishlistId()) && Objects.equals(getProductId(), wishlist.getProductId()) && Objects.equals(getUserId(), wishlist.getUserId()) && Objects.equals(getCreationTime(), wishlist.getCreationTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWishlistId(), getProductId(), getUserId(), isLiked(), getCreationTime());
    }

    @Override
    public String toString() {
        return "Wishlist{" +
                "wishlistId=" + wishlistId +
                ", productId=" + productId +
                ", userId=" + userId +
                ", isLiked=" + isLiked +
                ", creationTime=" + creationTime +
                '}';
    }
}
