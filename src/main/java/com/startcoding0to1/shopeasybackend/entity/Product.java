package com.startcoding0to1.shopeasybackend.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import com.startcoding0to1.shopeasybackend.generator.ProductIdGenerator;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.lang.NonNull;


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
	private int quantity;

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
	private int rating;

	@Column(name = "total_reviews")
	private int totalReviews;

	@NonNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "seller_id")
	private User seller;

	@Column(name = "creation_time")
	private LocalDateTime creationTime;

	@Column(name = "last_update_time")
	private LocalDateTime lastUpdateTime;

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getTotalReviews() {
		return totalReviews;
	}

	public void setTotalReviews(int totalReviews) {
		this.totalReviews = totalReviews;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return Double.compare(product.getProdPrice(), getProdPrice()) == 0 && Double.compare(product.getDiscountPrice(), getDiscountPrice()) == 0 && getQuantity() == product.getQuantity() && getRating() == product.getRating() && getTotalReviews() == product.getTotalReviews() && Objects.equals(getProductId(), product.getProductId()) && Objects.equals(getProductName(), product.getProductName()) && Objects.equals(getProdCategory(), product.getProdCategory()) && Objects.equals(getProdSubCategory(), product.getProdSubCategory()) && Objects.equals(getProdAvailability(), product.getProdAvailability()) && Objects.equals(getProductDesc(), product.getProductDesc()) && Objects.equals(getImageUrl(), product.getImageUrl()) && Objects.equals(getVideoUrl(), product.getVideoUrl()) && Objects.equals(getBrand(), product.getBrand()) && Objects.equals(getProductSize(), product.getProductSize()) && getSeller().equals(product.getSeller()) && Objects.equals(getCreationTime(), product.getCreationTime()) && Objects.equals(getLastUpdateTime(), product.getLastUpdateTime());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getProductId(), getProductName(), getProdCategory(), getProdSubCategory(), getProdPrice(), getDiscountPrice(), getQuantity(), getProdAvailability(), getProductDesc(), getImageUrl(), getVideoUrl(), getBrand(), getProductSize(), getRating(), getTotalReviews(), getSeller(), getCreationTime(), getLastUpdateTime());
	}

	@Override
	public String toString() {
		return "Product{" +
				"productId='" + productId + '\'' +
				", productName='" + productName + '\'' +
				", prodCategory='" + prodCategory + '\'' +
				", prodSubCategory='" + prodSubCategory + '\'' +
				", prodPrice=" + prodPrice +
				", discountPrice=" + discountPrice +
				", quantity=" + quantity +
				", prodAvailability='" + prodAvailability + '\'' +
				", productDesc='" + productDesc + '\'' +
				", imageUrl='" + imageUrl + '\'' +
				", videoUrl='" + videoUrl + '\'' +
				", brand='" + brand + '\'' +
				", productSize='" + productSize + '\'' +
				", rating=" + rating +
				", totalReviews=" + totalReviews +
				", seller=" + seller +
				", creationTime=" + creationTime +
				", lastUpdateTime=" + lastUpdateTime +
				'}';
	}
}