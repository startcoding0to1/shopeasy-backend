package com.startcoding0to1.shopeasybackend.repository;

import com.startcoding0to1.shopeasybackend.entity.*;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface AddressRepository extends CrudRepository<Address,Integer> {
    public Set<Address> findByUserAndAdminDetails(User user, AdminDetails adminDetails);
    public Set<Address> findByUserAndSellerDetails(User user, SellerDetails sellerDetails);
    public Set<Address> findByUserAndCustomerDetails(User user, CustomerDetails customerDetails);
    public Optional<Address> findByHouseNoAndStreetAndAdminDetails(String houseNo, String street,AdminDetails adminDetails);
    public Optional<Address> findByHouseNoAndStreetAndCustomerDetails(String houseNo, String street,CustomerDetails customerDetails);
    public Optional<Address> findByHouseNoAndStreetAndSellerDetails(String houseNo, String street,SellerDetails sellerDetails);
}
