package com.startcoding0to1.shopeasybackend.service;

import java.util.Set;
import com.startcoding0to1.shopeasybackend.dto.CartDTO;
import com.startcoding0to1.shopeasybackend.dto.SuccessResponse;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;

public interface CartService {

    public Set<CartDTO> getAllCartItems(Integer customerDetailsId) throws ShopEasyException;

    public SuccessResponse addCartItem(CartDTO cartDTO) throws ShopEasyException;

    public SuccessResponse updateCartItem(Integer cartId, CartDTO cartDTO) throws ShopEasyException;

    public SuccessResponse deleteCartItem(Integer cartId) throws ShopEasyException;
}
