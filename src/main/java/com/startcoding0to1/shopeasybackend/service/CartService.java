package com.startcoding0to1.shopeasybackend.service;

import com.startcoding0to1.shopeasybackend.dto.CartDTO;
import com.startcoding0to1.shopeasybackend.dto.UserDTO;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;

import java.util.List;
import java.util.Set;

public interface CartService {

    public Set<CartDTO> getAllCartItems(Integer customerDetailsId) throws ShopEasyException;

    public String addCartItem(CartDTO cartDTO) throws ShopEasyException;

    public String updateCartItem(Integer cartId, CartDTO cartDTO) throws ShopEasyException;

    public String deleteCartItem(Integer cartId) throws ShopEasyException;
}
