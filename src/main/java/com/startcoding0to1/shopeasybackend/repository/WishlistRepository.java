package com.startcoding0to1.shopeasybackend.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.startcoding0to1.shopeasybackend.entity.CustomerDetails;
import com.startcoding0to1.shopeasybackend.entity.Product;
import com.startcoding0to1.shopeasybackend.entity.Wishlist;

public interface WishlistRepository extends CrudRepository<Wishlist,Integer> {

    public List<Wishlist> findByCustomerDetails(CustomerDetails customerDetails);
    public List<Wishlist> findByCustomerDetailsAndProduct(CustomerDetails customerDetails, Product product);
    @Modifying
    @Query("DELETE FROM Wishlist w WHERE w.wishlistId = :wishlistId")
    public void deleteByWishlistId(Integer wishlistId);
}
