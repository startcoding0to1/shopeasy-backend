    package com.startcoding0to1.shopeasybackend.controller;

    import com.fasterxml.jackson.databind.ObjectMapper;
    import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
    import com.startcoding0to1.shopeasybackend.dto.AdminDetailsDTO;
    import com.startcoding0to1.shopeasybackend.dto.CustomerDetailsDTO;
    import com.startcoding0to1.shopeasybackend.dto.SellerDetailsDTO;
    import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
    import com.startcoding0to1.shopeasybackend.service.UserDetailsService;
    import com.startcoding0to1.shopeasybackend.serviceimpl.UserAdminDetailsServiceImpl;
    import com.startcoding0to1.shopeasybackend.serviceimpl.UserCustomerDetailsServiceImpl;
    import com.startcoding0to1.shopeasybackend.serviceimpl.UserSellerDetailsServiceImpl;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.context.ApplicationContext;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping(value = "/startcoding0to1/shopEasy")
    public class UserDetailsController {
        @Autowired
        private ApplicationContext applicationContext;
        @Autowired
        private ObjectMapper objectMapper;

        @GetMapping(value = "/userDetails/{id}")
        public ResponseEntity<String> getUserDetailId(@PathVariable(name = "id") String userId,@RequestParam(name = "userType") String userType) throws ShopEasyException{
            if(userId==null || userId.isEmpty()){
                throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY, HttpStatus.BAD_REQUEST);
            }
            String userDetailsId="UserDetailsId: ";
            switch (userType.toLowerCase()){
                case "admin":
                    userDetailsId += applicationContext.getBean("userAdminDetailsServiceImpl",UserAdminDetailsServiceImpl.class)
                            .getUserDetailsId(userId);
                    break;
                case "customer":
                    userDetailsId += applicationContext.getBean("userCustomerDetailsServiceImpl", UserCustomerDetailsServiceImpl.class)
                            .getUserDetailsId(userId);
                    break;
                case "seller":
                    userDetailsId += applicationContext.getBean("userSellerDetailsServiceImpl", UserSellerDetailsServiceImpl.class)
                            .getUserDetailsId(userId);
                    break;
                default:
                    userDetailsId += "User type is required...";
            }
            return new ResponseEntity<>(userDetailsId,HttpStatus.OK);
        }

        @PostMapping(value = "/userDetails")
        public ResponseEntity<String> addUserDetails(@RequestBody Object userDetailsDto,@RequestParam(name = "userType") String userType) throws ShopEasyException {
            if(userDetailsDto==null){
                throw new ShopEasyException(ShopEasyConstants.RESOURCE_IS_EMPTY, HttpStatus.BAD_REQUEST);
            }
            String message="";
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
                    message += "User type is required...";
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
                    message = "User type is required...";
            }
            return new ResponseEntity<>(message,HttpStatus.OK);
        }

    }
