package com.startcoding0to1.shopeasybackend.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator ="address_id_gen")
    @SequenceGenerator(name = "address_id_gen",sequenceName = "address_id_seq",allocationSize = 1)
    @Column(name = "address_id")
    private Integer addressId;

    @Column(name = "house_no")
    private String houseNo;

    @Column(name = "street")
    private String street;

    @Column(name = "landmark")
    private String landmark;

    @Column(name = "pincode")
    private Long pincode;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
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
