package com.startcoding0to1.shopeasybackend.entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "customer_details")
public class CustomerDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cus_det_id_gen")
    @SequenceGenerator(name = "cus_det_id_gen",sequenceName = "customer_details_sequence",allocationSize = 1)
    @Column(name = "customer_Id")
    private Integer customerId;
    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "user_id")
    private User user;
    @Column(name = "premium_customer")
    private String premiumCustomer;
    @OneToMany(mappedBy = "customerDetails",cascade = CascadeType.REMOVE,orphanRemoval = true)
    private Set<Address> deliveryAddresses;
    @OneToMany(mappedBy = "customerDetails",cascade = CascadeType.REMOVE,orphanRemoval = true)
    private Set<Wishlist> wishlists;
    @OneToMany(mappedBy = "customerDetails",cascade = CascadeType.REMOVE,orphanRemoval = true)
    private Set<Cart> carts;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPremiumCustomer() {
        return premiumCustomer;
    }

    public void setPremiumCustomer(String premiumCustomer) {
        this.premiumCustomer = premiumCustomer;
    }

    public Set<Address> getDeliveryAddresses() {
        return deliveryAddresses;
    }

    public void setDeliveryAddresses(Set<Address> deliveryAddresses) {
        this.deliveryAddresses = deliveryAddresses;
    }

    public Set<Wishlist> getWishlists() {
        return wishlists;
    }

    public void setWishlists(Set<Wishlist> wishlists) {
        this.wishlists = wishlists;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }
}
