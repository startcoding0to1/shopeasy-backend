package com.startcoding0to1.shopeasybackend.dto;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class WishlistDTO {
    private Integer wishlistId;
    private String productId;
    private Integer customerDetailsId;
    private boolean isLiked;
    private String creationTime;

    public Integer getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(Integer wishlistId) {
        this.wishlistId = wishlistId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getCustomerDetailsId() {
        return customerDetailsId;
    }

    public void setCustomerDetailsId(Integer customerDetailsId) {
        this.customerDetailsId = customerDetailsId;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

}
