package com.startcoding0to1.shopeasybackend.service;

import java.util.Set;
import com.startcoding0to1.shopeasybackend.dto.AddressDTO;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;

public interface AddressService {

    public Set<AddressDTO> getAllUserAddresses(Integer userDetailsId,String userId,String typeOfUser) throws ShopEasyException;

    public String addAddress(AddressDTO addressDTO,String typeOfUser) throws ShopEasyException;

    public String updateAddress(Integer addressId,AddressDTO addressDTO) throws ShopEasyException;

    public String deleteAddress(Integer addressId) throws ShopEasyException;
}
