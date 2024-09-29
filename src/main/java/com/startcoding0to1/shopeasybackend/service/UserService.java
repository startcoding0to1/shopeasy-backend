package com.startcoding0to1.shopeasybackend.service;

import java.util.List;

import com.startcoding0to1.shopeasybackend.dto.AuthRequest;
import com.startcoding0to1.shopeasybackend.dto.AuthResponse;
import com.startcoding0to1.shopeasybackend.dto.SuccessResponse;
import com.startcoding0to1.shopeasybackend.dto.UserDTO;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;

public interface UserService {

    public AuthResponse registerUser(UserDTO userDTO) throws ShopEasyException;
    
    public SuccessResponse uploadImg(String userId,byte[] profileImg) throws ShopEasyException;

    public AuthResponse authentication(AuthRequest authRequest) throws ShopEasyException;

    public List<UserDTO> getAllUsers() throws ShopEasyException;

    public UserDTO getUser(String userId) throws ShopEasyException;

    public SuccessResponse updateUser(String userId, UserDTO userDTO) throws ShopEasyException;

    public SuccessResponse deleteUser(String userId) throws ShopEasyException;
}
