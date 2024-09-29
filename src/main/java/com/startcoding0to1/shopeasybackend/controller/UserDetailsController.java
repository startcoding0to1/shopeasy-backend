    package com.startcoding0to1.shopeasybackend.controller;

    import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.dto.AdminDetailsDTO;
import com.startcoding0to1.shopeasybackend.dto.CustomerDetailsDTO;
import com.startcoding0to1.shopeasybackend.dto.SellerDetailsDTO;
import com.startcoding0to1.shopeasybackend.dto.SuccessResponse;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.serviceimpl.UserAdminDetailsServiceImpl;
import com.startcoding0to1.shopeasybackend.serviceimpl.UserCustomerDetailsServiceImpl;
import com.startcoding0to1.shopeasybackend.serviceimpl.UserSellerDetailsServiceImpl;

    @RestController
    @RequestMapping(value = "/startcoding0to1/shopEasy")
    @CrossOrigin(origins = "http://localhost:4200/")
    public class UserDetailsController {
        @Autowired
        private ApplicationContext applicationContext;
        @Autowired
        private ObjectMapper objectMapper;

        @GetMapping(value = "/userDetails/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<SuccessResponse> getUserDetailId(@PathVariable(name = "id") String userId,@RequestParam(name = "userType") String userType) throws ShopEasyException{
            if(userId==null || userId.isEmpty()){
                throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY, HttpStatus.BAD_REQUEST);
            }
            SuccessResponse successResponse = new SuccessResponse();
            switch (userType.toLowerCase()){
                case "admin":
                	successResponse.setId(applicationContext.getBean("userAdminDetailsServiceImpl",UserAdminDetailsServiceImpl.class)
                            .getUserDetailsId(userId).toString());
                    break;
                case "customer":
                	successResponse.setId(applicationContext.getBean("userCustomerDetailsServiceImpl", UserCustomerDetailsServiceImpl.class)
                            .getUserDetailsId(userId).toString());
                    break;
                case "seller":
                	successResponse.setId(applicationContext.getBean("userSellerDetailsServiceImpl", UserSellerDetailsServiceImpl.class)
                            .getUserDetailsId(userId).toString());
                    break;
                default:
                	throw new ShopEasyException(ShopEasyConstants.USER_TYPE_IS_REQUIRED+0, HttpStatus.BAD_REQUEST);
            }
            successResponse.setMessage(ShopEasyConstants.SUCCESSFULLY_FETCHED+userId);
            return new ResponseEntity<>(successResponse,HttpStatus.OK);
        }

        @PostMapping(value = "/userDetails")
        public ResponseEntity<SuccessResponse> addUserDetails(@RequestBody Object userDetailsDto,@RequestParam(name = "userType") String userType) throws ShopEasyException {
            if(userDetailsDto==null){
                throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY, HttpStatus.BAD_REQUEST);
            }
            SuccessResponse message = null;
            switch (userType.toLowerCase()){
                case "admin":
                	message = applicationContext.getBean("userAdminDetailsServiceImpl",UserAdminDetailsServiceImpl.class)
                            .addUserDetails(objectMapper.convertValue(userDetailsDto,AdminDetailsDTO.class));
                    break;
                case "customer":
                	message = applicationContext.getBean("userCustomerDetailsServiceImpl", UserCustomerDetailsServiceImpl.class)
                            .addUserDetails(objectMapper.convertValue(userDetailsDto,CustomerDetailsDTO.class));
                    break;
                case "seller":
                	message = applicationContext.getBean("userSellerDetailsServiceImpl", UserSellerDetailsServiceImpl.class)
                            .addUserDetails(objectMapper.convertValue(userDetailsDto,SellerDetailsDTO.class));
                    break;
                default:
                	throw new ShopEasyException(ShopEasyConstants.USER_TYPE_IS_REQUIRED+0, HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(message,HttpStatus.CREATED);
        }

        @DeleteMapping(value = "/userDetails/{id}")
        public ResponseEntity<String> deleteUserDetail(@PathVariable(name = "id") Integer userDetailsID,@RequestParam(name = "userType") String userType) throws ShopEasyException{
            if(userDetailsID==null){
                throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY, HttpStatus.BAD_REQUEST);
            }
            String message="";
            switch (userType.toLowerCase()){
                case "admin":
                    message = applicationContext.getBean("userAdminDetailsServiceImpl",UserAdminDetailsServiceImpl.class)
                            .deleteUserDetails(userDetailsID);
                    break;
                case "customer":
                    message = applicationContext.getBean("userCustomerDetailsServiceImpl", UserCustomerDetailsServiceImpl.class)
                            .deleteUserDetails(userDetailsID);
                    break;
                case "seller":
                    message = applicationContext.getBean("userSellerDetailsServiceImpl", UserSellerDetailsServiceImpl.class)
                            .deleteUserDetails(userDetailsID);
                    break;
                default:
                	throw new ShopEasyException(ShopEasyConstants.USER_TYPE_IS_REQUIRED+0, HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>(message,HttpStatus.OK);
        }

    }
