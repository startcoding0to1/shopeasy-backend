package com.startcoding0to1.shopeasybackend.serviceimpl;

import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.dto.SellerDetailsDTO;
import com.startcoding0to1.shopeasybackend.entity.Role;
import com.startcoding0to1.shopeasybackend.entity.SellerDetails;
import com.startcoding0to1.shopeasybackend.entity.User;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.repository.SellerDetailsRepository;
import com.startcoding0to1.shopeasybackend.service.ProductsService;
import com.startcoding0to1.shopeasybackend.service.UserDetailsService;
import com.startcoding0to1.shopeasybackend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.Optional;

@Service(value = "userSellerDetailsServiceImpl")
@Transactional
public class UserSellerDetailsServiceImpl implements UserDetailsService<SellerDetailsDTO> {

    @Autowired
    private UserService userService;
    @Autowired
    private SellerDetailsRepository sellerDetailsRepository;
    @Autowired
    private ProductsService productsService;
    @Autowired
    private ModelMapper MODELMAPPER;
    @Override
    public Integer getUserDetailsId(String userId) throws ShopEasyException {
        User user =  MODELMAPPER.map(userService.getUser(userId),User.class);
        Optional<SellerDetails> optional = sellerDetailsRepository.findByUser(user);
        SellerDetails sellerDetails = optional.orElseThrow(() -> new ShopEasyException(ShopEasyConstants.SELLER_DETAILS_DOES_NOT_FOUND_FOR_GIVEN_USER_ID + userId, HttpStatus.NOT_FOUND));
        return sellerDetails.getSellerId();
    }

    @Override
    public String addUserDetails(SellerDetailsDTO userDetailsDto) throws ShopEasyException {
        SellerDetails sellerDetails;
        Integer customerDetailsId=null;
        SellerDetailsDTO sellerDetailsDTO = (SellerDetailsDTO)userDetailsDto;
        if(sellerDetailsDTO!=null && sellerDetailsDTO.getUserId() != null && !sellerDetailsDTO.getUserId().isEmpty()){
            User user =  MODELMAPPER.map(userService.getUser(userDetailsDto.getUserId()),User.class);
            boolean flag=false;
            Iterator<Role> iterator = user.getRoles().iterator();
            while (iterator.hasNext()){
                if(iterator.next()==Role.SELLER){
                    flag = true;
                }
            }
            if(flag==false){
                throw new ShopEasyException(ShopEasyConstants.YOU_DONT_HAVE_ROLE_SELLER_TO_ADD_SELLER_DEATAILS,HttpStatus.BAD_REQUEST);
            }else{
                sellerDetails = MODELMAPPER.map(sellerDetailsDTO,SellerDetails.class);
                customerDetailsId = sellerDetailsRepository.save(sellerDetails).getSellerId();
            }
        }else {
            throw new ShopEasyException(ShopEasyConstants.USER_ID_IS_REQUIRED_TO_ADD_SELLER_DETAILS,HttpStatus.BAD_REQUEST);
        }
        return ShopEasyConstants.RECORD_SUCCESSFULLY_ADDED+customerDetailsId;
    }

    @Override
    public String deleteUserDetails(Integer userDetailsId) throws ShopEasyException {
        Optional<SellerDetails> optional = sellerDetailsRepository.findById(userDetailsId);
        optional.orElseThrow(() -> new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_SELLER_DETAILS_ID + userDetailsId, HttpStatus.NOT_FOUND));
        sellerDetailsRepository.deleteBySellerId(userDetailsId);
        return ShopEasyConstants.RECORD_SUCCESSFULLY_DELETED+userDetailsId;
    }
}
