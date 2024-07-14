package com.startcoding0to1.shopeasybackend.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Data Transfer Object (DTO) for Products.
 * This class represents the structure of product data that is transferred between the frontend and backend.
 * It provides getters and setters for accessing and modifying product attributes.
 *
 * @author Mahammad Khairuddin
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ProductDTO {
	private String productId;

	private String productName;

	private String prodCategory;

	private String prodSubCategory;

	private double prodPrice;

	private double discountPrice;

	private Integer quantity;

	private String prodAvailability;

	private String productDesc;

	private String imageUrl;

	private String videoUrl;

	private String brand;

	private String productSize;

	private Integer rating;

	private Integer sellerId;

	private Integer totalReviews;

	private String creationTime;

	private String lastUpdateTime;

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

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public String getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(String creationTime) {
		this.creationTime = creationTime;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brand, creationTime, discountPrice, imageUrl, lastUpdateTime, prodAvailability,
				prodCategory, prodPrice, prodSubCategory, productDesc, productId, productName, productSize, quantity,
				rating, sellerId, totalReviews, videoUrl);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDTO other = (ProductDTO) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(creationTime, other.creationTime)
				&& Double.doubleToLongBits(discountPrice) == Double.doubleToLongBits(other.discountPrice)
				&& Objects.equals(imageUrl, other.imageUrl) && Objects.equals(lastUpdateTime, other.lastUpdateTime)
				&& Objects.equals(prodAvailability, other.prodAvailability)
				&& Objects.equals(prodCategory, other.prodCategory)
				&& Double.doubleToLongBits(prodPrice) == Double.doubleToLongBits(other.prodPrice)
				&& Objects.equals(prodSubCategory, other.prodSubCategory)
				&& Objects.equals(productDesc, other.productDesc) && Objects.equals(productId, other.productId)
				&& Objects.equals(productName, other.productName) && Objects.equals(productSize, other.productSize)
				&& Objects.equals(quantity, other.quantity) && Objects.equals(rating, other.rating)
				&& Objects.equals(sellerId, other.sellerId) && Objects.equals(totalReviews, other.totalReviews)
				&& Objects.equals(videoUrl, other.videoUrl);
	}

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", prodCategory=" + prodCategory
				+ ", prodSubCategory=" + prodSubCategory + ", prodPrice=" + prodPrice + ", discountPrice="
				+ discountPrice + ", quantity=" + quantity + ", prodAvailability=" + prodAvailability + ", productDesc="
				+ productDesc + ", imageUrl=" + imageUrl + ", videoUrl=" + videoUrl + ", brand=" + brand
				+ ", productSize=" + productSize + ", rating=" + rating + ", sellerId=" + sellerId + ", totalReviews="
				+ totalReviews + ", creationTime=" + creationTime + ", lastUpdateTime=" + lastUpdateTime + "]";
	}
	
}