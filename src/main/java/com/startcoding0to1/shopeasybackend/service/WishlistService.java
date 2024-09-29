package com.startcoding0to1.shopeasybackend.service;

import java.util.Set;

import com.startcoding0to1.shopeasybackend.dto.SuccessResponse;
import com.startcoding0to1.shopeasybackend.dto.WishlistDTO;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;

public interface WishlistService {
    public Set<WishlistDTO> getAllWishlistItems(Integer customerDetailsId) throws ShopEasyException;
    public SuccessResponse addWishlistitem(WishlistDTO wishlistDTO) throws ShopEasyException;
    public SuccessResponse deleteWishlistitem(Integer wishlistId) throws ShopEasyException;
}
