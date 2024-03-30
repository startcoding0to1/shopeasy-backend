package com.startcoding0to1.shopeasybackend.service;

import java.util.List;

import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.dto.ProductsDTO;

/**
 * Service interface for managing product-related operations.
 * 
 * @author Mahammad Khairuddin
 */
public interface ProductsService {
    
    /**
     * Retrieves all products.
     * 
     * @return A list of ProductsDTO representing all products.
     * @throws ShopEasyException if an error occurs while retrieving products.
     */
    public List<ProductsDTO> getAllProducts() throws ShopEasyException;
    
    /**
     * Retrieves a product by its ID.
     * 
     * @param prodId The ID of the product to retrieve.
     * @return The ProductsDTO representing the product with the specified ID.
     * @throws ShopEasyException if the product with the specified ID is not found.
     */
    public ProductsDTO getProductById(String prodId) throws ShopEasyException;
    
    /**
     * Adds a new product.
     * 
     * @param productsDTO The ProductsDTO representing the product to add.
     * @return A message indicating the result of the operation.
     * @throws ShopEasyException if an error occurs while adding the product.
     */
    public String addProduct(ProductsDTO productsDTO) throws ShopEasyException;
    
    /**
     * Updates an existing product.
     * 
     * @param prodId The ID of the product to update.
     * @param productsDTO The ProductsDTO containing the updated product information.
     * @return A message indicating the result of the operation.
     * @throws ShopEasyException if the product with the specified ID is not found or an error occurs while updating the product.
     */
    public String updateProduct(String prodId, ProductsDTO productsDTO) throws ShopEasyException;
    
    /**
     * Deletes a product.
     * 
     * @param prodId The ID of the product to delete.
     * @return A message indicating the result of the operation.
     * @throws ShopEasyException if the product with the specified ID is not found or an error occurs while deleting the product.
     */
    public String deleteProduct(String prodId) throws ShopEasyException;
}
