package com.startcoding0to1.shopeasybackend.entity;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.Objects;

import org.hibernate.annotations.GenericGenerator;

import com.startcoding0to1.shopeasybackend.dto.ProductsDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


/**
 * Entity class representing Products.
 * This class maps to the 'products' table in the database and contains attributes for product information.
 * It also includes methods for updating product details based on a DTO.
 * 
 * @author Mahammad Khairuddin
 */

@Entity
@Table(name = "products")
public class Products {
	@Id
//	@SequenceGenerator(name = "product_id_seq", sequenceName = "product_id_seq", allocationSize = 1) 
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_id_seq")
	@GenericGenerator(name="product_id_seq",strategy="com.startcoding0to1.shopeasybackend.generator.ProductIdGenerator")
	@GeneratedValue(generator = "product_id_seq")
	
	@Column(name = "product_id",length = 200)
	private String productId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "prod_category")
	private String prodCategory;

	@Column(name = "prod_price")
	private double prodPrice;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "product_desc")
	private String productDesc;

	@Column(name = "manufacturer")
	private String manufacturer;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "video_url")
	private String videoUrl;

	@Column(name = "manufacturer_date")
	private Date manufacturerDate;

	@Column(name = "expiry_date")
	private Date expiryDate;

	@Column(name = "brand")
	private String brand;

	@Column(name = "color")
	private String color;

	@Column(name = "product_size")
	private String productSize;

	@Column(name = "weight")
	private double weight;

	@Column(name = "dimensions")
	private String dimensions;

	@Column(name = "material")
	private String material;

	@Column(name = "sku", unique = true)
	private String sku;

	@Column(name = "barcode", unique = true)
	private String barcode;

	@Column(name = "regular_price")
	private double regularPrice;

	@Column(name = "discount_price")
	private double discountPrice;

	@Column(name = "currency")
	private String currency;

	@Column(name = "prod_availability")
	private String prodAvailability;

	@Column(name = "reorder_point")
	private int reorderPoint;

	@Column(name = "warehouse_location")
	private String warehouseLocation;

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "last_updated_date")
	private Date lastUpdatedDate;

	@Column(name = "rating")
	private int rating;

	@Column(name = "total_reviews")
	private int totalReviews;

	@Column(name = "featured_product")
	private char featuredProduct;
	
	public Products() {
		
	}
	
	/**
	 * Updates the product details based on the provided DTO.
	 * 
	 * @param productsDTO The DTO containing updated product information.
	 * @author Mahammad Khairuddin
	 */
	public Products(ProductsDTO productsDTO) {
		this.productName = productsDTO.getProductName();
		this.prodCategory = productsDTO.getProdCategory();
		this.prodPrice = productsDTO.getProdPrice();
		this.quantity = productsDTO.getQuantity();
		this.productDesc = productsDTO.getProductDesc();
		this.manufacturer = productsDTO.getManufacturer();
		this.imageUrl = productsDTO.getImageUrl();
		this.videoUrl = productsDTO.getVideoUrl();
		this.manufacturerDate = productsDTO.getManufacturerDate();
		this.expiryDate = productsDTO.getExpiryDate();
		this.brand = productsDTO.getBrand();
		this.color = productsDTO.getColor();
		this.productSize = productsDTO.getProductSize();
		this.weight = productsDTO.getWeight();
		this.dimensions = productsDTO.getDimensions();
		this.material = productsDTO.getMaterial();
		this.sku = productsDTO.getSku();
		this.barcode = productsDTO.getBarcode();
		this.regularPrice = productsDTO.getRegularPrice();
		this.discountPrice = productsDTO.getDiscountPrice();
		this.currency = productsDTO.getCurrency();
		this.prodAvailability = productsDTO.getProdAvailability();
		this.reorderPoint = productsDTO.getReorderPoint();
		this.warehouseLocation = productsDTO.getWarehouseLocation();
		this.createdDate = productsDTO.getCreatedDate();
		this.lastUpdatedDate = productsDTO.getLastUpdatedDate();
		this.rating = productsDTO.getRating();
		this.totalReviews = productsDTO.getTotalReviews();
		this.featuredProduct = productsDTO.getFeaturedProduct();
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

	@Override
	public int hashCode() {
		return Objects.hash(barcode, brand, color, createdDate, currency, dimensions, discountPrice, expiryDate,
				featuredProduct, imageUrl, lastUpdatedDate, manufacturer, manufacturerDate, material, prodAvailability,
				prodCategory, prodPrice, productDesc, productId, productName, productSize, quantity, rating,
				regularPrice, reorderPoint, sku, totalReviews, videoUrl, warehouseLocation, weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		return Objects.equals(barcode, other.barcode) && Objects.equals(brand, other.brand)
				&& Objects.equals(color, other.color) && Objects.equals(createdDate, other.createdDate)
				&& Objects.equals(currency, other.currency) && Objects.equals(dimensions, other.dimensions)
				&& Double.doubleToLongBits(discountPrice) == Double.doubleToLongBits(other.discountPrice)
				&& Objects.equals(expiryDate, other.expiryDate) && featuredProduct == other.featuredProduct
				&& Objects.equals(imageUrl, other.imageUrl) && Objects.equals(lastUpdatedDate, other.lastUpdatedDate)
				&& Objects.equals(manufacturer, other.manufacturer)
				&& Objects.equals(manufacturerDate, other.manufacturerDate) && Objects.equals(material, other.material)
				&& Objects.equals(prodAvailability, other.prodAvailability)
				&& Objects.equals(prodCategory, other.prodCategory)
				&& Double.doubleToLongBits(prodPrice) == Double.doubleToLongBits(other.prodPrice)
				&& Objects.equals(productDesc, other.productDesc) && Objects.equals(productId, other.productId)
				&& Objects.equals(productName, other.productName) && Objects.equals(productSize, other.productSize)
				&& quantity == other.quantity && rating == other.rating
				&& Double.doubleToLongBits(regularPrice) == Double.doubleToLongBits(other.regularPrice)
				&& reorderPoint == other.reorderPoint && Objects.equals(sku, other.sku)
				&& totalReviews == other.totalReviews && Objects.equals(videoUrl, other.videoUrl)
				&& Objects.equals(warehouseLocation, other.warehouseLocation)
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}

	/**
	 * Updates the product details based on the provided DTO.
	 * 
	 * @param productsDTO The DTO containing updated product information.
	 * @return The updated Products entity.
	 * @author Mahammad Khairuddin
	 */
	public void updateProducts(ProductsDTO productsDTO,Products products) {
		Field [] fieldsDto=ProductsDTO.class.getDeclaredFields();
		
		for(Field fieldDto:fieldsDto) {
			 try {
	                fieldDto.setAccessible(true);
	                String fieldName = fieldDto.getName();
	                Object value = fieldDto.get(productsDTO);
	                if(fieldName != "productId") {
	                	Field field=Products.class.getDeclaredField(fieldName);
		                field.setAccessible(true);
		                field.set(products, value);
	                }
	                
	            } catch (IllegalAccessException | NoSuchFieldException e) {
	                e.printStackTrace();
	            }
		}		
	}
}