package com.startcoding0to1.shopeasybackend.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "wishlist")
public class Wishlist implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "wishlist_id_gen")
    @SequenceGenerator(name = "wishlist_id_gen" ,sequenceName = "wishlist_sequence",allocationSize = 1)
    @Column(name = "wishlist_id")
    private Integer wishlistId;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name="customerDetails_Id",nullable = false)
    private CustomerDetails customerDetails;

    @Column(name = "is_liked")
    private boolean isLiked;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    public Integer getWishlistId() {
        return wishlistId;
    }

    public void setWishlistId(Integer wishlistId) {
        this.wishlistId = wishlistId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setLiked(boolean liked) {
        isLiked = liked;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

	@Override
	public int hashCode() {
		return Objects.hash(creationTime, customerDetails, isLiked, product, wishlistId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wishlist other = (Wishlist) obj;
		return Objects.equals(creationTime, other.creationTime)
				&& Objects.equals(customerDetails, other.customerDetails) && isLiked == other.isLiked
				&& Objects.equals(product, other.product) && Objects.equals(wishlistId, other.wishlistId);
	}

	@Override
	public String toString() {
		return "Wishlist [wishlistId=" + wishlistId + ", product=" + product + ", customerDetails=" + customerDetails
				+ ", isLiked=" + isLiked + ", creationTime=" + creationTime + "]";
	}

}
