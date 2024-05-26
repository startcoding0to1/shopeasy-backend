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

    public Optional<Products> findByProductNameAndProdCategoryAndSellerAndBrand(String productName, String productCategory, String manufacturer, String brand);
}
