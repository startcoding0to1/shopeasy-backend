package com.startcoding0to1.shopeasybackend.serviceimpl;

import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.dto.AdminDetailsDTO;
import com.startcoding0to1.shopeasybackend.entity.AdminDetails;
import com.startcoding0to1.shopeasybackend.entity.Role;
import com.startcoding0to1.shopeasybackend.entity.User;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.repository.AdminDetailsRepository;
import com.startcoding0to1.shopeasybackend.service.UserDetailsService;
import com.startcoding0to1.shopeasybackend.service.UserService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.Iterator;
import java.util.Optional;

@Service(value = "userAdminDetailsServiceImpl")
@Transactional
public class UserAdminDetailsServiceImpl implements UserDetailsService<AdminDetailsDTO> {

    @Autowired
    private UserService userService;
    @Autowired
    private AdminDetailsRepository adminDetailsRepository;
    @Autowired
    private ModelMapper MODELMAPPER;

    @Override
    public Integer getUserDetailsId(String userId) throws ShopEasyException {
        User user =  MODELMAPPER.map(userService.getUser(userId),User.class);
        Optional<AdminDetails> optional = adminDetailsRepository.findByUser(user);
        AdminDetails adminDetails = optional.orElseThrow(() -> new ShopEasyException(ShopEasyConstants.ADMIN_DETAILS_DOES_NOT_FOUND_FOR_GIVEN_USER_ID + userId, HttpStatus.NOT_FOUND));
        return adminDetails.getAdminId();
    }

    @Override
    public String addUserDetails(AdminDetailsDTO userDetailsDto) throws ShopEasyException {
        AdminDetails adminDetails;
        Integer adminDetailsId=null;
        AdminDetailsDTO adminDetailsDTO = (AdminDetailsDTO)userDetailsDto;
        if(adminDetailsDTO!=null && adminDetailsDTO.getUserId() != null && !adminDetailsDTO.getUserId().isEmpty()){
            User user =  MODELMAPPER.map(userService.getUser(userDetailsDto.getUserId()),User.class);
            boolean flag=false;
            Iterator<Role> iterator = user.getRoles().iterator();
            while (iterator.hasNext()){
                if(iterator.next()==Role.ADMIN){
                    flag = true;
                }
            }
            if(flag==false){
                throw new ShopEasyException(ShopEasyConstants.YOU_DONT_HAVE_ROLE_ADMIN_TO_ADD_ADMIN_DEATAILS,HttpStatus.BAD_REQUEST);
            }else{
                adminDetails = MODELMAPPER.map(adminDetailsDTO,AdminDetails.class);
                adminDetailsId = adminDetailsRepository.save(adminDetails).getAdminId();
            }
        }else {
            throw new ShopEasyException(ShopEasyConstants.USER_ID_IS_REQUIRED_TO_ADD_ADMIN_DETAILS,HttpStatus.BAD_REQUEST);
        }
        return ShopEasyConstants.RECORD_SUCCESSFULLY_ADDED+adminDetailsId;
    }

    @Override
    public String deleteUserDetails(Integer userDetailsId) throws ShopEasyException {
        Optional<AdminDetails> optional = adminDetailsRepository.findById(userDetailsId);
        optional.orElseThrow(()->new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_ADMIN_DETAILS_ID+userDetailsId,HttpStatus.NOT_FOUND));
        adminDetailsRepository.deleteById(userDetailsId);
        return ShopEasyConstants.RECORD_SUCCESSFULLY_DELETED+userDetailsId;
    }
}
