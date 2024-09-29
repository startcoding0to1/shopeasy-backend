package com.startcoding0to1.shopeasybackend.service;

import java.util.List;
import java.util.Set;

import com.startcoding0to1.shopeasybackend.dto.ProductDTO;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;

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
    public List<ProductDTO> getAllProducts(String category) throws ShopEasyException;
    
    /**
     * Retrieves a product by its ID.
     * 
     * @param prodId The ID of the product to retrieve.
     * @return The ProductsDTO representing the product with the specified ID.
     * @throws ShopEasyException if the product with the specified ID is not found.
     */
    public ProductDTO getProductById(String prodId) throws ShopEasyException;
    
    /**
     * Adds a new product.
     * 
     * @param productsDTO The ProductsDTO representing the product to add.
     * @return A message indicating the result of the operation.
     * @throws ShopEasyException if an error occurs while adding the product.
     */
    public String addProduct(ProductDTO productsDTO) throws ShopEasyException;
    
    /**
     * Updates an existing product.
     * 
     * @param prodId The ID of the product to update.
     * @param productsDTO The ProductsDTO containing the updated product information.
     * @return A message indicating the result of the operation.
     * @throws ShopEasyException if the product with the specified ID is not found or an error occurs while updating the product.
     */
    public String updateProduct(String prodId, ProductDTO productsDTO) throws Exception;
    
    /**
     * Deletes a product.
     * 
     * @param prodId The ID of the product to delete.
     * @return A message indicating the result of the operation.
     * @throws ShopEasyException if the product with the specified ID is not found or an error occurs while deleting the product.
     */
    public String deleteProduct(String prodId) throws ShopEasyException;

    public Set<ProductDTO> getAllProductsOfGivenSeller(Integer sellerId) throws ShopEasyException;

}
