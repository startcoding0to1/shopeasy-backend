package com.startcoding0to1.shopeasybackend.repository;

import com.startcoding0to1.shopeasybackend.entity.CustomerDetails;
import com.startcoding0to1.shopeasybackend.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerDetailsRepository extends CrudRepository<CustomerDetails,Integer> {
    public Optional<CustomerDetails> findByUser(User user);
    @Modifying
    @Query("DELETE FROM CustomerDetails WHERE customerId = :customerId")
    public void deleteByCustomerId(Integer customerId);

}
