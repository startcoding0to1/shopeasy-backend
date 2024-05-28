package com.startcoding0to1.shopeasybackend.controller;

import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.dto.AuthRequest;
import com.startcoding0to1.shopeasybackend.dto.AuthResponse;
import com.startcoding0to1.shopeasybackend.dto.UserDTO;
import com.startcoding0to1.shopeasybackend.entity.User;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/startcoding0to1/shopEasy")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/auth/register")
    public ResponseEntity<AuthResponse> registerUser(@RequestBody UserDTO userDTO) throws ShopEasyException {
        if(userDTO==null){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY,HttpStatus.BAD_REQUEST);
        }
        AuthResponse authResponse = userService.registerUser(userDTO);

//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Custom-Header", "Success");
//
//        return new ResponseEntity<>(response, headers, HttpStatus.OK);

        return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
    }

    @PostMapping(value="/auth/login")
    public ResponseEntity<AuthResponse> authentication(@RequestBody AuthRequest authRequest) throws ShopEasyException {
        if(authRequest==null){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY,HttpStatus.BAD_REQUEST);
        }
        AuthResponse authResponse = userService.authentication(authRequest);
        return new ResponseEntity<>(authResponse,HttpStatus.OK);
    }

    @GetMapping(value = "/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() throws ShopEasyException {
        List<UserDTO> userDTOS = userService.getAllUsers();
        return new ResponseEntity<>(userDTOS,HttpStatus.OK);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable(name = "id") String userId) throws ShopEasyException {
        if(userId==null || userId.trim().isEmpty()){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY,HttpStatus.BAD_REQUEST);
        }
        UserDTO userDTO = userService.getUser(userId);
        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }

    @PutMapping(value="/user/{id}")
    public ResponseEntity<String> updateUser(@PathVariable(name = "id") String userId,@RequestBody UserDTO userDTO) throws ShopEasyException {
        if(userDTO==null || userId==null || userId.trim().isEmpty()){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY,HttpStatus.BAD_REQUEST);
        }
        String message = userService.updateUser(userId,userDTO);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id") String userId) throws ShopEasyException {
        if(userId==null || userId.trim().isEmpty()){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY,HttpStatus.BAD_REQUEST);
        }
        String message = userService.deleteUser(userId);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }


}
