package com.startcoding0to1.shopeasybackend.controller;

import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.dto.AuthRequest;
import com.startcoding0to1.shopeasybackend.dto.AuthResponse;
import com.startcoding0to1.shopeasybackend.dto.SuccessResponse;
import com.startcoding0to1.shopeasybackend.dto.UserDTO;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/startcoding0to1/shopEasy")
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/auth/register",produces = "application/json")
    public ResponseEntity<AuthResponse> registerUser(@RequestBody UserDTO userDTO) throws ShopEasyException {
        if(userDTO==null){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY,HttpStatus.BAD_REQUEST);
        }
        AuthResponse authResponse = userService.registerUser(userDTO);
        return new ResponseEntity<>(authResponse, HttpStatus.CREATED);
    }

    @PostMapping("/uploadProfileImg")
    public ResponseEntity<SuccessResponse> uploadProfileImage(@RequestParam("profileImg") MultipartFile file,
    		@RequestParam("userId") String userId) throws ShopEasyException {
    	if(userId==null){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY,HttpStatus.BAD_REQUEST);
        }
    	// Convert MultipartFile to byte[]
        byte[] profileImg;
		try {
			profileImg = file.getBytes();
		} catch (IOException e) {
			throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY,HttpStatus.BAD_REQUEST);
		}
        SuccessResponse successResponse = userService.uploadImg(userId,profileImg);
        return new ResponseEntity<>(successResponse, HttpStatus.OK);
    }
    
    @GetMapping("/deleteProfileImg/{userId}")
    public ResponseEntity<SuccessResponse> deleteProfileImage(@PathVariable(name = "userId") String userId)throws ShopEasyException{
    	if(userId==null){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY,HttpStatus.BAD_REQUEST);
        }
    	SuccessResponse successResponse = userService.updateUser(userId, new UserDTO());
    	return new ResponseEntity<>(successResponse, HttpStatus.OK);
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

    @GetMapping(value = "/user/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUser(@PathVariable(name = "id") String userId) throws ShopEasyException {
        if(userId==null || userId.trim().isEmpty()){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY,HttpStatus.BAD_REQUEST);
        }
        UserDTO userDTO = userService.getUser(userId);
        return new ResponseEntity<>(userDTO,HttpStatus.OK);
    }
    
    @PutMapping(value="/user/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SuccessResponse> updateUser(@PathVariable(name = "id") String userId,@RequestBody UserDTO userDTO) throws ShopEasyException {
        if(userDTO==null || userId==null || userId.trim().isEmpty()){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY,HttpStatus.BAD_REQUEST);
        }
        SuccessResponse successResponse = userService.updateUser(userId,userDTO);
        return new ResponseEntity<>(successResponse,HttpStatus.OK);
    }

    @DeleteMapping(value = "/user/{id}")
    public ResponseEntity<SuccessResponse> deleteUser(@PathVariable(name = "id") String userId) throws ShopEasyException {
        if(userId==null || userId.trim().isEmpty()){
            throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY,HttpStatus.BAD_REQUEST);
        }
        SuccessResponse successResponse = userService.deleteUser(userId);
        return new ResponseEntity<>(successResponse,HttpStatus.OK);
    }


}
