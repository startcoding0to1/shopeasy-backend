package com.startcoding0to1.shopeasybackend.service;

import com.startcoding0to1.shopeasybackend.dto.AuthRequest;
import com.startcoding0to1.shopeasybackend.dto.AuthResponse;
import com.startcoding0to1.shopeasybackend.dto.UserDTO;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;

import java.util.List;

public interface UserService {

    public AuthResponse registerUser(UserDTO userDTO) throws ShopEasyException;

    public AuthResponse authentication(AuthRequest authRequest) throws ShopEasyException;

    public List<UserDTO> getAllUsers() throws ShopEasyException;

    public UserDTO getUser(String userId) throws ShopEasyException;

    public String updateUser(String userId, UserDTO userDTO) throws ShopEasyException;

    public String deleteUser(String userId) throws ShopEasyException;
}
