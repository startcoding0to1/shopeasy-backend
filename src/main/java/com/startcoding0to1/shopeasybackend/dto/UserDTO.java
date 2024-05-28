package com.startcoding0to1.shopeasybackend.dto;

import com.startcoding0to1.shopeasybackend.entity.Role;

import java.util.Set;

public class UserDTO {

    private String userId;
    private String userFirstName;
    private String userLastName;
    private Set<AddressDTO> address;
    private Long phoneNumber;
    private String userEmail;
    private String userPassword;
    private Set<Role> roles;
    private Set<ProductDTO> purchasedProducts;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public Set<AddressDTO> getAddress() {
        return address;
    }

    public void setAddress(Set<AddressDTO> address) {
        this.address = address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<ProductDTO> getPurchasedProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(Set<ProductDTO> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }
}