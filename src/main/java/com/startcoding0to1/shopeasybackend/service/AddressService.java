package com.startcoding0to1.shopeasybackend.service;

import com.startcoding0to1.shopeasybackend.dto.AddressDTO;
import com.startcoding0to1.shopeasybackend.dto.UserDTO;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;

import java.util.Set;

public interface AddressService {

    public Set<AddressDTO> getAllUserAddresses(UserDTO userId);

    public String addAddress(AddressDTO addressDTO) throws ShopEasyException;

    public String updateAddress(Integer addressId,AddressDTO addressDTO) throws ShopEasyException;

    public String deleteAddress(Integer addressId) throws ShopEasyException;
}
