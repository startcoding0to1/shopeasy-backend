package com.startcoding0to1.shopeasybackend.controller;

import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.dto.CartDTO;
import com.startcoding0to1.shopeasybackend.dto.SuccessResponse;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;

@RestController
@RequestMapping(value = "/startcoding0to1/shopEasy")
@CrossOrigin(origins = "http://localhost:4200/")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping(value = "/cartItems/{id}",produces = "application/json")
    public ResponseEntity<Set<CartDTO>> getAllCartItems(@PathVariable(name = "id")Integer customerDetailsId) throws ShopEasyException {
        if(customerDetailsId == null){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY, HttpStatus.BAD_REQUEST);
        }
        Set<CartDTO> carts = cartService.getAllCartItems(customerDetailsId);
        return new ResponseEntity<>(carts,HttpStatus.OK);
    }

    @PostMapping(value = "/cartItem")
    public ResponseEntity<SuccessResponse> addCartItem(@RequestBody CartDTO cartDTO) throws ShopEasyException {
        if(cartDTO == null || cartDTO.getCustomerDetailsId()==null){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY, HttpStatus.BAD_REQUEST);
        }
        SuccessResponse meassage = cartService.addCartItem(cartDTO);
        return new ResponseEntity<>(meassage,HttpStatus.CREATED);
    }
    @PutMapping(value = "/cartItem/{id}")
    public ResponseEntity<SuccessResponse> updateCartItem(@PathVariable(name = "id") Integer cartId,@RequestBody CartDTO cartDTO) throws ShopEasyException {
        if(cartId == null || cartDTO == null){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY, HttpStatus.BAD_REQUEST);
        }
        SuccessResponse meassage = cartService.updateCartItem(cartId,cartDTO);
        return new ResponseEntity<>(meassage,HttpStatus.OK);
    }
    @DeleteMapping(value = "/cartItem/{id}")
    public ResponseEntity<SuccessResponse> deleteCartItem(@PathVariable(name = "id") Integer cartId) throws ShopEasyException {
        if(cartId == null){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY, HttpStatus.BAD_REQUEST);
        }
        SuccessResponse meassage = cartService.deleteCartItem(cartId);
        return new ResponseEntity<>(meassage,HttpStatus.OK);
    }
}
