package com.startcoding0to1.shopeasybackend.controller;

import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.dto.*;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/startcoding0to1/shopEasy")
@CrossOrigin(origins = "http://localhost:4200/")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping(value = "/addresses/{userDetailsId}/{userId}",produces = "application/json")
    public ResponseEntity<Set<AddressDTO>> getAllUserAddresses(@PathVariable(name = "userDetailsId") Integer userDetailsId,@PathVariable(name = "userId")String userId,@RequestParam(name="type") String typeOfUser) throws ShopEasyException {
        if(userDetailsId == null || userId == null){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY, HttpStatus.BAD_REQUEST);
        }
        Set<AddressDTO> addressDTOS;
        switch (typeOfUser.toLowerCase()){
            case "admin":
                addressDTOS = addressService.getAllUserAddresses(userDetailsId,userId,"admin");
                break;
            case "customer":
                addressDTOS = addressService.getAllUserAddresses(userDetailsId,userId,"customer");
                break;
            case "seller":
                addressDTOS = addressService.getAllUserAddresses(userDetailsId,userId,"seller");
                break;
            default:
                throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(addressDTOS,HttpStatus.OK);
    }

    @PostMapping(value = "/address")
    public ResponseEntity<String> addAddress(@RequestBody AddressDTO addressDTO,@RequestParam(name="type") String typeOfUser)throws ShopEasyException {
        if(addressDTO==null){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY, HttpStatus.BAD_REQUEST);
        }
        String message = addressService.addAddress(addressDTO,typeOfUser);
        return new ResponseEntity<>(message,HttpStatus.CREATED);
    }

    @PutMapping(value = "/address/{id}")
    public ResponseEntity<String> updateAddress(@PathVariable(name = "id") Integer addressId,@RequestBody AddressDTO addressDTO)throws ShopEasyException {
        if(addressId==null || addressDTO==null){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY, HttpStatus.BAD_REQUEST);
        }
        String message = addressService.updateAddress(addressId,addressDTO);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @DeleteMapping(value = "/address/{id}")
    public ResponseEntity<String> deleteAddress(@PathVariable(name = "id") Integer addressId)throws ShopEasyException {
        if(addressId==null){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY, HttpStatus.BAD_REQUEST);
        }
        String message = addressService.deleteAddress(addressId);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
}
