package com.startcoding0to1.shopeasybackend.repository;

import java.util.Optional;

import com.startcoding0to1.shopeasybackend.entity.User;
import org.springframework.data.repository.CrudRepository;

import com.startcoding0to1.shopeasybackend.entity.Product;

/**
 * Repository interface for accessing product data in the database.
 * This interface provides CRUD operations for Products entities.
 * 
 * @author Mahammad Khairuddin
 */
public interface ProductsRepository extends CrudRepository<Product, String> {

    public Optional<Product> findByProductNameAndProdCategoryAndProdSubCategoryAndSellerAndBrand(String productName, String productCategory,String productSubCategory, User seller, String brand);
}
