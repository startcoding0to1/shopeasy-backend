package com.startcoding0to1.shopeasybackend.service;

import java.util.Set;
import com.startcoding0to1.shopeasybackend.dto.CartDTO;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;

public interface CartService {

    public Set<CartDTO> getAllCartItems(Integer customerDetailsId) throws ShopEasyException;

    public String addCartItem(CartDTO cartDTO) throws ShopEasyException;

    public String updateCartItem(Integer cartId, CartDTO cartDTO) throws ShopEasyException;

    public String deleteCartItem(Integer cartId) throws ShopEasyException;
}
