package com.startcoding0to1.shopeasybackend.dto;


import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;

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

	@Override
	public int hashCode() {
		return Objects.hash(creationTime, customerDetailsId, isLiked, productId, wishlistId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WishlistDTO other = (WishlistDTO) obj;
		return Objects.equals(creationTime, other.creationTime)
				&& Objects.equals(customerDetailsId, other.customerDetailsId) && isLiked == other.isLiked
				&& Objects.equals(productId, other.productId) && Objects.equals(wishlistId, other.wishlistId);
	}

	@Override
	public String toString() {
		return "WishlistDTO [wishlistId=" + wishlistId + ", productId=" + productId + ", customerDetailsId="
				+ customerDetailsId + ", isLiked=" + isLiked + ", creationTime=" + creationTime + "]";
	}
    
}
