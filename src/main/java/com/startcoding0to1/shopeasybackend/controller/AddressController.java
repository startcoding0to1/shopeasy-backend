package com.startcoding0to1.shopeasybackend.controller;

import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.dto.AddressDTO;
import com.startcoding0to1.shopeasybackend.dto.UserDTO;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/startcoding0to1/shopEasy")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping(value = "/addresses")
    public ResponseEntity<Set<AddressDTO>> getAllUserAddresses(@RequestBody UserDTO userId) throws ShopEasyException {
        if(userId==null){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY, HttpStatus.BAD_REQUEST);
        }
        Set<AddressDTO> addressDTOS = addressService.getAllUserAddresses(userId);
        return new ResponseEntity<>(addressDTOS,HttpStatus.OK);
    }

    @PostMapping(value = "address")
    public ResponseEntity<String> addAddress(@RequestBody AddressDTO addressDTO)throws ShopEasyException {
        if(addressDTO==null){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY, HttpStatus.BAD_REQUEST);
        }
        String message = addressService.addAddress(addressDTO);
        return new ResponseEntity<>(message,HttpStatus.CREATED);
    }

    @PutMapping(value = "address/{id}")
    public ResponseEntity<String> updateAddress(@PathVariable(name = "id") Integer addressId,@RequestBody AddressDTO addressDTO)throws ShopEasyException {
        if(addressId==null || addressDTO==null){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY, HttpStatus.BAD_REQUEST);
        }
        String message = addressService.updateAddress(addressId,addressDTO);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @DeleteMapping(value = "address/{id}")
    public ResponseEntity<String> deleteAddress(Integer addressId)throws ShopEasyException {
        if(addressId==null){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY, HttpStatus.BAD_REQUEST);
        }
        String message = addressService.deleteAddress(addressId);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
}
