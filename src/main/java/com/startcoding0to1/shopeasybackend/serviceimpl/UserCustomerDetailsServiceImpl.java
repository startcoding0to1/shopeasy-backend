package com.startcoding0to1.shopeasybackend.serviceimpl;

import java.util.Iterator;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.dto.CustomerDetailsDTO;
import com.startcoding0to1.shopeasybackend.entity.CustomerDetails;
import com.startcoding0to1.shopeasybackend.entity.Role;
import com.startcoding0to1.shopeasybackend.entity.User;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.repository.CustomerDetailsRepository;
import com.startcoding0to1.shopeasybackend.repository.UserRepository;
import com.startcoding0to1.shopeasybackend.service.CartService;
import com.startcoding0to1.shopeasybackend.service.UserDetailsService;
import com.startcoding0to1.shopeasybackend.service.UserService;
import com.startcoding0to1.shopeasybackend.service.WishlistService;
@Service(value = "userCustomerDetailsServiceImpl")
@Transactional
public class UserCustomerDetailsServiceImpl implements UserDetailsService<CustomerDetailsDTO> {

    @Autowired
    private UserService userService;
    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;
    @Autowired
    private ModelMapper MODELMAPPER;
    @Override
    public Integer getUserDetailsId(String userId) throws ShopEasyException {
        User user =  MODELMAPPER.map(userService.getUser(userId),User.class);
        Optional<CustomerDetails> optional = customerDetailsRepository.findByUser(user);
        CustomerDetails customerDetails = optional.orElseThrow(() -> new ShopEasyException(ShopEasyConstants.CUSTOMER_DETAILS_DOES_NOT_FOUND_FOR_GIVEN_USER_ID + userId, HttpStatus.NOT_FOUND));
        return customerDetails.getCustomerId();
    }

    @Override
    public String addUserDetails(CustomerDetailsDTO userDetailsDto) throws ShopEasyException {
        CustomerDetails customerDetails;
        Integer customerDetailsId=null;
        CustomerDetailsDTO customerDetailsDTO = userDetailsDto;
        if(customerDetailsDTO!=null && customerDetailsDTO.getUserId() != null && !customerDetailsDTO.getUserId().isEmpty()){
            User user =  MODELMAPPER.map(userService.getUser(customerDetailsDTO.getUserId()),User.class);
            boolean flag=false;
            Iterator<Role> iterator = user.getRoles().iterator();
            while (iterator.hasNext()){
                if(iterator.next()==Role.CUSTOMER){
                    flag = true;
                }
            }
            if(flag==false){
                throw new ShopEasyException(ShopEasyConstants.YOU_DONT_HAVE_ROLE_CUSTOMER_TO_ADD_CUSTOMER_DEATAILS,HttpStatus.BAD_REQUEST);
            }else{
                customerDetails = MODELMAPPER.map(customerDetailsDTO,CustomerDetails.class);
                customerDetailsId = customerDetailsRepository.save(customerDetails).getCustomerId();
            }
        }else {
            throw new ShopEasyException(ShopEasyConstants.USER_ID_IS_REQUIRED_TO_ADD_CUSTOMER_DETAILS,HttpStatus.BAD_REQUEST);
        }
        return ShopEasyConstants.RECORD_SUCCESSFULLY_ADDED+customerDetailsId;
    }

    @Override
    public String deleteUserDetails(Integer userDetailsId) throws ShopEasyException {
        Optional<CustomerDetails> optional = customerDetailsRepository.findById(userDetailsId);
        optional.orElseThrow(() -> new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_CUSTOMER_DETAILS_ID + userDetailsId, HttpStatus.NOT_FOUND));
        customerDetailsRepository.deleteByCustomerId(userDetailsId);
        return ShopEasyConstants.RECORD_SUCCESSFULLY_DELETED+userDetailsId;
    }
}
