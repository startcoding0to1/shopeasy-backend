package com.startcoding0to1.shopeasybackend.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import com.startcoding0to1.shopeasybackend.generator.ProductIdGenerator;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;


/**
 * Entity class representing Products.
 * This class maps to the 'products' table in the database and contains attributes for product information.
 * It also includes methods for updating product details based on a DTO.
 *
 * @author Mahammad Khairuddin
 */

@Entity
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GenericGenerator(name = "product_id_seq", type = ProductIdGenerator.class)
	@GeneratedValue(generator = "product_id_seq")
	@Column(name = "product_id", length = 200)
	private String productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "prod_category")
	private String prodCategory;

	@Column(name = "prod_sub_category")
	private String prodSubCategory;

	@Column(name = "prod_price")
	private double prodPrice;

	@Column(name = "discount_price")
	private double discountPrice;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "prod_availability")
	private String prodAvailability;

	@Column(name = "product_desc")
	private String productDesc;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "video_url")
	private String videoUrl;

	@Column(name = "brand")
	private String brand;

	@Column(name = "product_size")
	private String productSize;

	@Column(name = "rating")
	private Integer rating;

	@Column(name = "total_reviews")
	private Integer totalReviews;

	@ManyToOne
	@JoinColumn(name = "seller_id",nullable = false)
	private SellerDetails seller;
	@Column(name = "creation_time")
	private LocalDateTime creationTime;
	@Column(name = "last_update_time")
	private LocalDateTime lastUpdateTime;
	@OneToOne(mappedBy = "product",cascade = CascadeType.REMOVE,orphanRemoval = true)
	private Wishlist wishlist;
	@OneToOne(mappedBy = "product",cascade = CascadeType.REMOVE,orphanRemoval = true)
	private Cart cart;
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProdCategory() {
		return prodCategory;
	}

	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}

	public String getProdSubCategory() {
		return prodSubCategory;
	}

	public void setProdSubCategory(String prodSubCategory) {
		this.prodSubCategory = prodSubCategory;
	}

	public double getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public double getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getProdAvailability() {
		return prodAvailability;
	}

	public void setProdAvailability(String prodAvailability) {
		this.prodAvailability = prodAvailability;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer getTotalReviews() {
		return totalReviews;
	}

	public void setTotalReviews(Integer totalReviews) {
		this.totalReviews = totalReviews;
	}

	public SellerDetails getSeller() {
		return seller;
	}

	public void setSeller(SellerDetails seller) {
		this.seller = seller;
	}

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public LocalDateTime getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public Wishlist getWishlist() {
		return wishlist;
	}
	public void setWishlist(Wishlist wishlist) {
		this.wishlist = wishlist;
	}
	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

}