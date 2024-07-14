package com.startcoding0to1.shopeasybackend.repository;

import com.startcoding0to1.shopeasybackend.entity.Cart;
import com.startcoding0to1.shopeasybackend.entity.CustomerDetails;
import com.startcoding0to1.shopeasybackend.entity.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface CartRepository extends CrudRepository<Cart, Integer> {
    public Set<Cart> findByCustomerDetails(CustomerDetails customerDetails);
    public Set<Cart> findByProductAndCustomerDetails(Product product, CustomerDetails customerDetails);


    @Modifying
    @Query("DELETE FROM Cart WHERE cartId = :cartId")
    public void deleteByCartId(@Param("cartId") Integer cartId);
}
