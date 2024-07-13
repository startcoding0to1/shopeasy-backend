package com.startcoding0to1.shopeasybackend.repository;

import com.startcoding0to1.shopeasybackend.entity.SellerDetails;
import com.startcoding0to1.shopeasybackend.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SellerDetailsRepository extends CrudRepository<SellerDetails,Integer> {
    public Optional<SellerDetails> findByUser(User user);
    @Modifying
    @Query("DELETE FROM SellerDetails s WHERE s.sellerId = ?1")
    public void deleteBySellerId(Integer sellerID);

}
