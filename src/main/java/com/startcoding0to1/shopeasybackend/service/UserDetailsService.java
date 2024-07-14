package com.startcoding0to1.shopeasybackend.service;

import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;

public interface UserDetailsService<O> {
    public Integer getUserDetailsId(String userId) throws ShopEasyException;
    public String addUserDetails(O userDetailsDto) throws ShopEasyException;
    public String deleteUserDetails(Integer userDetailsId) throws ShopEasyException;
}
