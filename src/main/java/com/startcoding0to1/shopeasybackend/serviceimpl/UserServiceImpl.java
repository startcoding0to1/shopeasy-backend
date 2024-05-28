package com.startcoding0to1.shopeasybackend.serviceimpl;

import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.dto.*;
import com.startcoding0to1.shopeasybackend.entity.Address;
import com.startcoding0to1.shopeasybackend.entity.User;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.repository.AddressRepository;
import com.startcoding0to1.shopeasybackend.repository.ProductsRepository;
import com.startcoding0to1.shopeasybackend.repository.UserRepository;
import com.startcoding0to1.shopeasybackend.service.AddressService;
import com.startcoding0to1.shopeasybackend.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ProductsRepository productsRepository;

    @Override
    public AuthResponse registerUser(UserDTO userDTO) throws ShopEasyException {
        Optional<User> optional = userRepository.findByUserEmail(userDTO.getUserEmail());
        if (optional.isPresent()) {
            throw new ShopEasyException(ShopEasyConstants.RECORD_ALREADY_EXIST+userDTO.getUserEmail(), HttpStatus.CONFLICT);
        }
        User user = dtoToEntity(userDTO);
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTime=localDateTime.format(dateTimeFormatter);
        user.setCreationTime(LocalDateTime.parse(currentTime,dateTimeFormatter));
        user.setLastUpdateTime(LocalDateTime.parse(currentTime,dateTimeFormatter));
        user=userRepository.save(user);
        userDTO.setUserId(user.getUserId());
        AuthResponse authResponse = new AuthResponse();
        authResponse.setMessage(ShopEasyConstants.USER_SUCCESSFULLY_REGISTERED);
        authResponse.setUserDTO(userDTO);
        authResponse.setJwtToken("1234567890");
        return authResponse;
    }


    @Override
    public AuthResponse authentication(AuthRequest authRequest) throws ShopEasyException {
        Optional<User> optional=userRepository.findByUserEmail(authRequest.getUserEmail());
        User user=optional.orElseThrow(()->new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_USER_EMAIL_ID+authRequest.getUserEmail(),HttpStatus.NOT_FOUND));
        if(!user.getUserEmail().equals(authRequest.getUserEmail()) && !user.getUserPassword().equals(authRequest.getUserPassword())){
            throw new ShopEasyException(ShopEasyConstants.INVALID_CREDENTIALS,HttpStatus.UNAUTHORIZED);
        }
        UserDTO userDTO=entityToDTO(user);
        AuthResponse authResponse  = new AuthResponse();
        authResponse.setMessage(ShopEasyConstants.USER_SUCCESSFULLY_LOGIN);
        authResponse.setUserDTO(userDTO);
        authResponse.setJwtToken("1234567890");
        return authResponse;
    }

    @Override
    public List<UserDTO> getAllUsers() throws ShopEasyException {
        Iterable<User> iterable = userRepository.findAll();
        List<UserDTO> userDTOS=new ArrayList<UserDTO>();
        iterable.forEach(user -> {
            UserDTO userDTO = entityToDTO(user);
            userDTOS.add(userDTO);
        });
        if(userDTOS==null){
            throw new ShopEasyException(ShopEasyConstants.NO_USERS_FOUND,HttpStatus.NOT_FOUND);
        }
        return userDTOS;
    }

    @Override
    public UserDTO getUser(String userId) throws ShopEasyException {
        Optional<User> optional = userRepository.findById(userId);
        User user=optional.orElseThrow(()-> new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_USER_ID+userId,HttpStatus.NOT_FOUND));
        UserDTO userDTO=entityToDTO(user);
        return userDTO;
    }

    @Override
    public String updateUser(String userId, UserDTO userDTO) throws ShopEasyException {
        Optional<User> optional=userRepository.findById(userId);
        User user=optional.orElseThrow(() -> new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_USER_ID+userId,HttpStatus.NOT_FOUND));
        user.setUserFirstName(userDTO.getUserFirstName()!=null?userDTO.getUserFirstName():user.getUserFirstName());
        user.setUserLastName(userDTO.getUserLastName()!=null?userDTO.getUserLastName():user.getUserLastName());
        user.setUserEmail(userDTO.getUserEmail()!=null?userDTO.getUserEmail():user.getUserEmail());
        user.setRoles(userDTO.getRoles()!=null?userDTO.getRoles():user.getRoles());
        user.setUserPassword(userDTO.getUserPassword()!=null?userDTO.getUserPassword():user.getUserPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber()!=null?userDTO.getPhoneNumber():user.getPhoneNumber());
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String currentTime=localDateTime.format(dateTimeFormatter);
        user.setLastUpdateTime(LocalDateTime.parse(currentTime,dateTimeFormatter));
        return ShopEasyConstants.RECORD_SUCCESSFULLY_UPDATED+user.getUserId();
    }



    @Override
    public String deleteUser(String userId) throws ShopEasyException {
        Optional<User> optional=userRepository.findById(userId);
        User user=optional.orElseThrow(()->new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_USER_ID+userId,HttpStatus.NOT_FOUND));
        UserDTO userDTO=new UserDTO();
        userDTO.setUserId(user.getUserId());
        Set<AddressDTO> addressDTOS=addressService.getAllUserAddresses(userDTO);
        if(addressDTOS != null){
            addressDTOS.forEach(addressDTO -> {
                try {
                    addressService.deleteAddress(addressDTO.getAddressId());
                } catch (ShopEasyException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        userRepository.deleteById(user.getUserId());
        return ShopEasyConstants.RECORD_SUCCESSFULLY_DELETED+userId;
    }

    private User dtoToEntity(UserDTO userDTO) {
        User user = new User();
        user.setUserFirstName(userDTO.getUserFirstName());
        user.setUserLastName(userDTO.getUserLastName());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setUserEmail(userDTO.getUserEmail());
        user.setUserPassword(userDTO.getUserPassword());
        user.setRoles(userDTO.getRoles());
        return user;
    }

    public static UserDTO entityToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUserFirstName(user.getUserFirstName());
        userDTO.setUserLastName(user.getUserLastName());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setUserEmail(user.getUserEmail());
        userDTO.setUserPassword(user.getUserPassword());
        userDTO.setRoles(user.getRoles());
        return userDTO;
    }
}
