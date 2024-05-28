package com.startcoding0to1.shopeasybackend.dto;

import com.startcoding0to1.shopeasybackend.entity.Address;
import com.startcoding0to1.shopeasybackend.entity.User;

import java.util.Objects;

public class AddressDTO {

    private Integer addressId;
    private String houseNo;
    private String street;
    private String landmark;
    private Long pincode;
    private String city;
    private String state;
    private User userId;

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public Long getPincode() {
        return pincode;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(getAddressId(), address.getAddressId()) && Objects.equals(getHouseNo(), address.getHouseNo()) && Objects.equals(getStreet(), address.getStreet()) && Objects.equals(getLandmark(), address.getLandmark()) && Objects.equals(getPincode(), address.getPincode()) && Objects.equals(getCity(), address.getCity()) && Objects.equals(getState(), address.getState()) && Objects.equals(getUserId(), address.getUserId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddressId(), getHouseNo(), getStreet(), getLandmark(), getPincode(), getCity(), getState(), getUserId());
    }

    @Override
    public String toString() {
        return "Address{" +
                "AddressId=" + addressId +
                ", houseNo='" + houseNo + '\'' +
                ", street='" + street + '\'' +
                ", landmark='" + landmark + '\'' +
                ", pincode=" + pincode +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", user=" + userId +
                '}';
    }
}
