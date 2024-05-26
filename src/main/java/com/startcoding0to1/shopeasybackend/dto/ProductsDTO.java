package com.startcoding0to1.shopeasybackend.dto;

import com.startcoding0to1.shopeasybackend.entity.Products;
import jakarta.annotation.Nullable;

/**
 * Data Transfer Object (DTO) for Products.
 * This class represents the structure of product data that is transferred between the frontend and backend.
 * It provides getters and setters for accessing and modifying product attributes.
 *
 * @author Mahammad Khairuddin
 */
public class ProductsDTO {
	private String productId;

	private String productName;

	private String prodCategory;

	private String prodSubCategory;

	private double prodPrice;

	private double discountPrice;

	private int quantity;

	private String prodAvailability;

	private String productDesc;

	@Nullable
	private String seller;

	@Nullable
	private String customer;

	private String imageUrl;

	private String videoUrl;

	private String brand;

	private String productSize;

	private int rating;

	private int totalReviews;

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

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	ProductsDTO(){}

	public ProductsDTO(Products products) {
		this.productId = products.getProductId();
		this.productName = products.getProductName();
		this.prodCategory = products.getProdCategory();
		this.prodSubCategory = products.getProdSubCategory();
		this.prodPrice = products.getProdPrice();
		this.discountPrice = products.getDiscountPrice();
		this.quantity = products.getQuantity();
		this.prodAvailability = products.getProdAvailability();
		this.productDesc = products.getProductDesc();
		this.seller = products.getSeller();
		this.customer = products.getCustomer();
		this.imageUrl = products.getImageUrl();
		this.videoUrl = products.getVideoUrl();
		this.brand = products.getBrand();
		this.productSize = products.getProductSize();
		this.rating = products.getRating();
		this.totalReviews = products.getTotalReviews();
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
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
}