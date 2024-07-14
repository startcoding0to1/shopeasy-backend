package com.startcoding0to1.shopeasybackend.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class CartDTO {
    private Integer cartId;
    private Integer customerDetailsId;
    private String productId;
    private Integer quantity;
    private String creationTime;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Integer getCustomerDetailsId() {
        return customerDetailsId;
    }

    public void setCustomerDetailsId(Integer customerDetailsId) {
        this.customerDetailsId = customerDetailsId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

	@Override
	public int hashCode() {
		return Objects.hash(cartId, creationTime, customerDetailsId, productId, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartDTO other = (CartDTO) obj;
		return Objects.equals(cartId, other.cartId) && Objects.equals(creationTime, other.creationTime)
				&& Objects.equals(customerDetailsId, other.customerDetailsId)
				&& Objects.equals(productId, other.productId) && Objects.equals(quantity, other.quantity);
	}

	@Override
	public String toString() {
		return "CartDTO [cartId=" + cartId + ", customerDetailsId=" + customerDetailsId + ", productId=" + productId
				+ ", quantity=" + quantity + ", creationTime=" + creationTime + "]";
	}
    
}