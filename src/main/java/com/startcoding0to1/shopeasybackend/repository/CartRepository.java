package com.startcoding0to1.shopeasybackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.startcoding0to1.shopeasybackend.entity.Cart;
import com.startcoding0to1.shopeasybackend.entity.CustomerDetails;
import com.startcoding0to1.shopeasybackend.entity.Product;

public interface CartRepository extends CrudRepository<Cart, Integer> {
    public List<Cart> findByCustomerDetails(CustomerDetails customerDetails);
    public List<Cart> findByProductAndCustomerDetails(Product product, CustomerDetails customerDetails);


    @Modifying
    @Query("DELETE FROM Cart WHERE cartId = :cartId")
    public void deleteByCartId(@Param("cartId") Integer cartId);
}
