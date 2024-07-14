package com.startcoding0to1.shopeasybackend.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AddressDTO {

    private Integer addressId;
    private String houseNo;
    private String street;
    private String landmark;
    private Long pincode;
    private String city;
    private String state;
    private String userId;
    private Integer adminId;
    private Integer sellerId;
    private Integer customerId;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

	@Override
	public int hashCode() {
		return Objects.hash(addressId, adminId, city, customerId, houseNo, landmark, pincode, sellerId, state, street,
				userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressDTO other = (AddressDTO) obj;
		return Objects.equals(addressId, other.addressId) && Objects.equals(adminId, other.adminId)
				&& Objects.equals(city, other.city) && Objects.equals(customerId, other.customerId)
				&& Objects.equals(houseNo, other.houseNo) && Objects.equals(landmark, other.landmark)
				&& Objects.equals(pincode, other.pincode) && Objects.equals(sellerId, other.sellerId)
				&& Objects.equals(state, other.state) && Objects.equals(street, other.street)
				&& Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "AddressDTO [addressId=" + addressId + ", houseNo=" + houseNo + ", street=" + street + ", landmark="
				+ landmark + ", pincode=" + pincode + ", city=" + city + ", state=" + state + ", userId=" + userId
				+ ", adminId=" + adminId + ", sellerId=" + sellerId + ", customerId=" + customerId + "]";
	}
    
    
}
