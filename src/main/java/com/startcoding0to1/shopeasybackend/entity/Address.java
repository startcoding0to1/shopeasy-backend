package com.startcoding0to1.shopeasybackend.entity;

import com.startcoding0to1.shopeasybackend.dto.AddressDTO;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "address")
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "admin_details_id")
    private AdminDetails adminDetails;

    @ManyToOne
    @JoinColumn(name = "customer_details_id")
    private CustomerDetails customerDetails;

    @ManyToOne
    @JoinColumn(name = "seller_details_id")
    private SellerDetails sellerDetails;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public AdminDetails getAdminDetails() {
        return adminDetails;
    }

    public void setAdminDetails(AdminDetails adminDetails) {
        this.adminDetails = adminDetails;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public SellerDetails getSellerDetails() {
        return sellerDetails;
    }

    public void setSellerDetails(SellerDetails sellerDetails) {
        this.sellerDetails = sellerDetails;
    }
}
