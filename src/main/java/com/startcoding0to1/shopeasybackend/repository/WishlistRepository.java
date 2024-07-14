package com.startcoding0to1.shopeasybackend.repository;

import com.startcoding0to1.shopeasybackend.entity.CustomerDetails;
import com.startcoding0to1.shopeasybackend.entity.Product;
import com.startcoding0to1.shopeasybackend.entity.User;
import com.startcoding0to1.shopeasybackend.entity.Wishlist;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import java.util.Set;

public interface WishlistRepository extends CrudRepository<Wishlist,Integer> {

    public Set<Wishlist> findByCustomerDetails(CustomerDetails customerDetails);
    public Set<Wishlist> findByCustomerDetailsAndProduct(CustomerDetails customerDetails, Product product);
    @Modifying
    @Query("DELETE FROM Wishlist w WHERE w.wishlistId = :wishlistId")
    public void deleteByWishlistId(Integer wishlistId);
}
