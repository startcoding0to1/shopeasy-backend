package com.startcoding0to1.shopeasybackend.controller;


import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.dto.WishlistDTO;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping(value = "/startcoding0to1/shopEasy")
public class WishListController {
    @Autowired
    private WishlistService wishlistService;

    @GetMapping(value = "/wishlistItem/{Id}",produces = "application/json")
    public ResponseEntity<Set<WishlistDTO>> getAllCartItems(@PathVariable(name = "Id") Integer customerDetailsId) throws ShopEasyException {
        if(customerDetailsId == null){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY, HttpStatus.BAD_REQUEST);
        }
        Set<WishlistDTO> carts = wishlistService.getAllWishlistItems(customerDetailsId);
        return new ResponseEntity<>(carts,HttpStatus.OK);
    }

    @PostMapping(value = "/wishlistItem")
    public ResponseEntity<String> addCartItem(@RequestBody WishlistDTO wishlistDTO) throws ShopEasyException {
        if(wishlistDTO == null){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY, HttpStatus.BAD_REQUEST);
        }
        String meassage = wishlistService.addWishlistitem(wishlistDTO);
        return new ResponseEntity<>(meassage,HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/wishlistItem/{id}")
    public ResponseEntity<String> deleteCartItem(@PathVariable(name = "id") Integer wishListId) throws ShopEasyException {
        if(wishListId == null){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY, HttpStatus.BAD_REQUEST);
        }
        String meassage = wishlistService.deleteWishlistitem(wishListId);
        return new ResponseEntity<>(meassage,HttpStatus.OK);
    }
}
