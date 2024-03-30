package com.startcoding0to1.shopeasybackend.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.startcoding0to1.shopeasybackend.entity.Products;

/**
 * Repository interface for accessing product data in the database.
 * This interface provides CRUD operations for Products entities.
 * 
 * @author Mahammad Khairuddin
 */
public interface ProductsRepository extends CrudRepository<Products, String> {
    
    /**
     * Finds a product by various attributes such as product name, category, manufacturer, brand, and barcode.
     * 
     * @param productName The name of the product.
     * @param productCategory The category of the product.
     * @param manufacturer The manufacturer of the product.
     * @param brand The brand of the product.
     * @param barcode The barcode of the product.
     * @return An optional containing the product if found, otherwise empty.
     */
    public Optional<Products> findByProductNameAndProdCategoryAndManufacturerAndBrandAndBarcode(String productName, String productCategory, String manufacturer, String brand, String barcode);
}
