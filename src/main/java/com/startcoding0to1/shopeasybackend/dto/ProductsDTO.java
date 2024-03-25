package com.startcoding0to1.shopeasybackend.dto;

import java.util.Date;

import com.startcoding0to1.shopeasybackend.entity.Products;

public class ProductsDTO {
	private String productId;
	private String productName;
	private String prodCategory;
	private double prodPrice;
	private int quantity;
	private String productDesc;
	private String manufacturer;
	private String imageUrl;
	private String videoUrl;
	private Date manufacturerDate;
	private Date expiryDate;
	private String brand;
	private String color;
	private String productSize;
	private double weight;
	private String dimensions;
	private String material;
	private String sku;
	private String barcode;
	private double regularPrice;
	private double discountPrice;
	private String currency;
	private String prodAvailability;
	private int reorderPoint;
	private String warehouseLocation;
	private Date createdDate;
	private Date lastUpdatedDate;
	private int rating;
	private int totalReviews;
	private char featuredProduct;

	public ProductsDTO(Products products) {
		this.productId = products.getProductId();
		this.productName = products.getProductName();
		this.prodCategory = products.getProdCategory();
		this.prodPrice = products.getProdPrice();
		this.quantity = products.getQuantity();
		this.productDesc = products.getProductDesc();
		this.manufacturer = products.getManufacturer();
		this.imageUrl = products.getImageUrl();
		this.videoUrl = products.getVideoUrl();
		this.manufacturerDate = products.getManufacturerDate();
		this.expiryDate = products.getExpiryDate();
		this.brand = products.getBrand();
		this.color = products.getColor();
		this.productSize = products.getProductSize();
		this.weight = products.getWeight();
		this.dimensions = products.getDimensions();
		this.material = products.getMaterial();
		this.sku = products.getSku();
		this.barcode = products.getBarcode();
		this.regularPrice = products.getRegularPrice();
		this.discountPrice = products.getDiscountPrice();
		this.currency = products.getCurrency();
		this.prodAvailability = products.getProdAvailability();
		this.reorderPoint = products.getReorderPoint();
		this.warehouseLocation = products.getWarehouseLocation();
		this.createdDate = products.getCreatedDate();
		this.lastUpdatedDate = products.getLastUpdatedDate();
		this.rating = products.getRating();
		this.totalReviews = products.getTotalReviews();
		this.featuredProduct = products.getFeaturedProduct();
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getProdCategory() {
		return prodCategory;
	}

	public double getProdPrice() {
		return prodPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public Date getManufacturerDate() {
		return manufacturerDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public String getBrand() {
		return brand;
	}

	public String getColor() {
		return color;
	}

	public String getProductSize() {
		return productSize;
	}

	public double getWeight() {
		return weight;
	}

	public String getDimensions() {
		return dimensions;
	}

	public String getMaterial() {
		return material;
	}

	public String getSku() {
		return sku;
	}

	public String getBarcode() {
		return barcode;
	}

	public double getRegularPrice() {
		return regularPrice;
	}

	public double getDiscountPrice() {
		return discountPrice;
	}

	public String getCurrency() {
		return currency;
	}

	public String getProdAvailability() {
		return prodAvailability;
	}

	public int getReorderPoint() {
		return reorderPoint;
	}

	public String getWarehouseLocation() {
		return warehouseLocation;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public int getRating() {
		return rating;
	}

	public int getTotalReviews() {
		return totalReviews;
	}

	public char getFeaturedProduct() {
		return featuredProduct;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}

	public void setProdPrice(double prodPrice) {
		this.prodPrice = prodPrice;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public void setManufacturerDate(Date manufacturerDate) {
		this.manufacturerDate = manufacturerDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setDimensions(String dimensions) {
		this.dimensions = dimensions;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public void setRegularPrice(double regularPrice) {
		this.regularPrice = regularPrice;
	}

	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setProdAvailability(String prodAvailability) {
		this.prodAvailability = prodAvailability;
	}

	public void setReorderPoint(int reorderPoint) {
		this.reorderPoint = reorderPoint;
	}

	public void setWarehouseLocation(String warehouseLocation) {
		this.warehouseLocation = warehouseLocation;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public void setTotalReviews(int totalReviews) {
		this.totalReviews = totalReviews;
	}

	public void setFeaturedProduct(char featuredProduct) {
		this.featuredProduct = featuredProduct;
	}
}