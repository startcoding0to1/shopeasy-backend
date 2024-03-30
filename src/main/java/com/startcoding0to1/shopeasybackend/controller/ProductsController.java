package com.startcoding0to1.shopeasybackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.dto.ProductsDTO;
import com.startcoding0to1.shopeasybackend.service.ProductsService;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {

    @Autowired
    ProductsService productsService;

    /**
     * Retrieve all products.
     *
     * @return ResponseEntity with a list of ProductsDTO and appropriate HTTP status.
     * @throws ShopEasyException if there is an error fetching the products.
     * @author Mahammad Khairuddin
     */
    @GetMapping(value = "/all")
    public ResponseEntity<List<ProductsDTO>> getAllProducts() throws ShopEasyException {
        List<ProductsDTO> products;
        try {
            products = productsService.getAllProducts();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (ShopEasyException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Retrieve a product by its ID.
     *
     * @param prodId The ID of the product to retrieve.
     * @return ResponseEntity with the ProductsDTO of the specified product and appropriate HTTP status.
     * @throws ShopEasyException if there is an error fetching the product.
     * @author Mahammad Khairuddin
     */
    @GetMapping(value="/product/{id}")
    public ResponseEntity<ProductsDTO> getProductById(@PathVariable(value="id") String prodId) throws ShopEasyException {
        ProductsDTO productsDTO = productsService.getProductById(prodId);
        return new ResponseEntity<>(productsDTO, HttpStatus.OK);
    }

    /**
     * Add a new product.
     *
     * @param productsDTO The DTO containing information about the product to add.
     * @return ResponseEntity with a success message and appropriate HTTP status.
     * @throws ShopEasyException if there is an error adding the product.
     * @author Mahammad Khairuddin
     */
    @PostMapping(value="/add")
    public ResponseEntity<String> addProduct(@RequestBody ProductsDTO productsDTO) throws ShopEasyException {
        String message = productsService.addProduct(productsDTO);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    /**
     * Update an existing product.
     *
     * @param prodId      The ID of the product to update.
     * @param productsDTO The DTO containing updated information about the product.
     * @return ResponseEntity with a success message and appropriate HTTP status.
     * @throws ShopEasyException if there is an error updating the product.
     * @author Mahammad Khairuddin
     */
    @PutMapping(value="/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable(value="id") String prodId, @RequestBody ProductsDTO productsDTO) throws ShopEasyException {
        String message = productsService.updateProduct(prodId, productsDTO);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    /**
     * Delete a product by its ID.
     *
     * @param prodId The ID of the product to delete.
     * @return ResponseEntity with a success message and appropriate HTTP status.
     * @throws ShopEasyException if there is an error deleting the product.
     * @author Mahammad Khairuddin
     */
    @DeleteMapping(value="/delete/{prodId}")
    public ResponseEntity<String> deleteProduct(@PathVariable String prodId) throws ShopEasyException {
        String message = productsService.deleteProduct(prodId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
