package com.startcoding0to1.shopeasybackend.entity;

import java.lang.reflect.Field;
import java.util.Objects;

import com.startcoding0to1.shopeasybackend.dto.ProductsDTO;
import com.startcoding0to1.shopeasybackend.generator.ProductIdGenerator;
import jakarta.annotation.Nullable;
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
public class Products {
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

	@Column(name = "seller")
	@Nullable
	private String seller;

	@Column(name = "customer")
	@Nullable
	private String customer;

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

	public void setTotalReviews(int totalReviews) {
		this.totalReviews = totalReviews;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return Double.compare(products.getProdPrice(), getProdPrice()) == 0 && Double.compare(products.getDiscountPrice(), getDiscountPrice()) == 0 && getQuantity() == products.getQuantity() && getRating() == products.getRating() && getTotalReviews() == products.getTotalReviews() && Objects.equals(getProductId(), products.getProductId()) && Objects.equals(getProductName(), products.getProductName()) && Objects.equals(getProdCategory(), products.getProdCategory()) && Objects.equals(getProdSubCategory(), products.getProdSubCategory()) && Objects.equals(getProdAvailability(), products.getProdAvailability()) && Objects.equals(getProductDesc(), products.getProductDesc()) && Objects.equals(getSeller(), products.getSeller()) && Objects.equals(getCustomer(), products.getCustomer()) && Objects.equals(getImageUrl(), products.getImageUrl()) && Objects.equals(getVideoUrl(), products.getVideoUrl()) && Objects.equals(getBrand(), products.getBrand()) && Objects.equals(getProductSize(), products.getProductSize());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProductId(), getProductName(), getProdCategory(), getProdSubCategory(), getProdPrice(), getDiscountPrice(), getQuantity(), getProdAvailability(), getProductDesc(), getSeller(), getCustomer(), getImageUrl(), getVideoUrl(), getBrand(), getProductSize(), getRating(), getTotalReviews());
    }

    @Override
    public String toString() {
        return "Products{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", prodCategory='" + prodCategory + '\'' +
                ", prodSubCategory='" + prodSubCategory + '\'' +
                ", prodPrice=" + prodPrice +
                ", discountPrice=" + discountPrice +
                ", quantity=" + quantity +
                ", prodAvailability='" + prodAvailability + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", seller='" + seller + '\'' +
                ", customer='" + customer + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", brand='" + brand + '\'' +
                ", productSize='" + productSize + '\'' +
                ", rating=" + rating +
                ", totalReviews=" + totalReviews +
                '}';
    }

}