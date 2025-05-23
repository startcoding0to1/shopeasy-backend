package com.startcoding0to1.shopeasybackend.repository;

import java.util.Optional;
import java.util.Set;
import org.springframework.data.repository.CrudRepository;
import com.startcoding0to1.shopeasybackend.entity.Product;
import com.startcoding0to1.shopeasybackend.entity.SellerDetails;

/**
 * Repository interface for accessing product data in the database.
 * This interface provides CRUD operations for Products entities.
 * 
 * @author Mahammad Khairuddin
 */
public interface ProductsRepository extends CrudRepository<Product, String> {

    public Set<Product> findBySeller(SellerDetails sellerDetails);
    public Optional<Product> findByProductNameAndProdCategoryAndProdSubCategoryAndSellerAndBrand(String productName, String productCategory, String productSubCategory, SellerDetails seller, String brand);
    public Iterable<Product> findByProdCategory(String productCategory);
}
