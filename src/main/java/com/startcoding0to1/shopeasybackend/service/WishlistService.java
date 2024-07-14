package com.startcoding0to1.shopeasybackend.service;

import com.startcoding0to1.shopeasybackend.dto.WishlistDTO;
import com.startcoding0to1.shopeasybackend.dto.UserDTO;
import com.startcoding0to1.shopeasybackend.entity.Wishlist;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;

import java.util.Set;

public interface WishlistService {
    public Set<WishlistDTO> getAllWishlistItems(Integer customerDetailsId) throws ShopEasyException;
    public String addWishlistitem(WishlistDTO wishlistDTO) throws ShopEasyException;
    public String deleteWishlistitem(Integer wishlistId) throws ShopEasyException;
}
