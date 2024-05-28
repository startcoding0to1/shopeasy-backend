package com.startcoding0to1.shopeasybackend.repository;

import com.startcoding0to1.shopeasybackend.dto.UserDTO;
import com.startcoding0to1.shopeasybackend.entity.Address;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface AddressRepository extends CrudRepository<Address,Integer> {

    public Set<Address> findByUserId(UserDTO userId);
    public Optional<Address> findByHouseNoAndStreet(String houseNo, String street);
}
