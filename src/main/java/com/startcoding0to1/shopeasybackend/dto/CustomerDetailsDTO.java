package com.startcoding0to1.shopeasybackend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class CustomerDetailsDTO{
    private Integer customerId;
    private String userId;
    private String premiumCustomer;
    private Set<WishlistDTO> wishlistDTOS;
    private Set<CartDTO> cartDTOS;
    private Set<AddressDTO> deliveryAddressesDTO;
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPremiumCustomer() {
        return premiumCustomer;
    }

    public void setPremiumCustomer(String premiumCustomer) {
        this.premiumCustomer = premiumCustomer;
    }

    public Set<WishlistDTO> getWishlistDTOS() {
        return wishlistDTOS;
    }

    public void setWishlistDTOS(Set<WishlistDTO> wishlistDTOS) {
        this.wishlistDTOS = wishlistDTOS;
    }

    public Set<CartDTO> getCartDTOS() {
        return cartDTOS;
    }

    public void setCartDTOS(Set<CartDTO> cartDTOS) {
        this.cartDTOS = cartDTOS;
    }

    public Set<AddressDTO> getDeliveryAddressesDTO() {
        return deliveryAddressesDTO;
    }

    public void setDeliveryAddressesDTO(Set<AddressDTO> deliveryAddressesDTO) {
        this.deliveryAddressesDTO = deliveryAddressesDTO;
    }
}
