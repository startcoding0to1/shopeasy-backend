package com.startcoding0to1.shopeasybackend.serviceimpl;

import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.dto.*;
import com.startcoding0to1.shopeasybackend.entity.Address;
import com.startcoding0to1.shopeasybackend.entity.User;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.repository.AddressRepository;
import com.startcoding0to1.shopeasybackend.repository.ProductsRepository;
import com.startcoding0to1.shopeasybackend.repository.UserRepository;
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
        if(userDTO.getAddress()!=null){
            Set<Address> addresses=new HashSet<Address>();
            Set<AddressDTO> addressDTOS=userDTO.getAddress();
            addressDTOS.forEach(addressDTO -> {
                Address address=updateAddress(addressDTO);
                addresses.add(address);
            });
            user.setAddress(addresses);
        }
        user.setUserFirstName(userDTO.getUserFirstName()!=null?userDTO.getUserFirstName():user.getUserFirstName());
        user.setUserLastName(userDTO.getUserLastName()!=null?userDTO.getUserLastName():user.getUserLastName());
        user.setUserEmail(userDTO.getUserEmail()!=null?userDTO.getUserEmail():user.getUserEmail());
        user.setRoles(userDTO.getRoles()!=null?userDTO.getRoles():user.getRoles());
        user.setUserPassword(userDTO.getUserPassword()!=null?userDTO.getUserPassword():user.getUserPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber()!=null?userDTO.getPhoneNumber():user.getPhoneNumber());
        return ShopEasyConstants.RECORD_SUCCESSFULLY_UPDATED+user.getUserId();
    }



    @Override
    public String deleteUser(String userId) throws ShopEasyException {
        Optional<User> optional=userRepository.findById(userId);
        User user=optional.orElseThrow(()->new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_USER_ID+userId,HttpStatus.NOT_FOUND));
        Set<Address> addresses=user.getAddress();
        addresses.forEach(address -> {
            addressRepository.deleteById(address.getAddressId());
        });
        userRepository.deleteById(userId);
        return ShopEasyConstants.RECORD_SUCCESSFULLY_DELETED+userId;
    }

    private static Address dtoToEntity(AddressDTO addressDTO){
        if(addressDTO==null){
            return null;
        }
        Address address=new Address();
        address.setHouseNo(addressDTO.getHouseNo());
        address.setCity(addressDTO.getCity());
        address.setStreet(addressDTO.getStreet());
        address.setLandmark(addressDTO.getLandmark());
        address.setState(addressDTO.getState());
        address.setPincode(addressDTO.getPincode());
        return address;
    }

    private User dtoToEntity(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        user.setUserFirstName(userDTO.getUserFirstName());
        user.setUserLastName(userDTO.getUserLastName());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setUserEmail(userDTO.getUserEmail());
        user.setUserPassword(userDTO.getUserPassword());
        user.setRoles(userDTO.getRoles());
        Set<AddressDTO> addressDTOS = userDTO.getAddress();
        if (addressDTOS != null) {
            Set<Address> addresses = new HashSet<>();
            for (AddressDTO addressDTO : addressDTOS) {
                Address address = dtoToEntity(addressDTO);
                if (address != null) {
                    address = addressRepository.save(address);
                    addressDTO.setAddressId(address.getAddressId());
                    addresses.add(address);
                }
            }
            user.setAddress(addresses);
        } else {
            user.setAddress(null);
        }
        return user;
    }


    private static AddressDTO entityToDTO(Address address) {
        if (address == null) {
            return null;
        }
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddressId(address.getAddressId());
        addressDTO.setHouseNo(address.getHouseNo());
        addressDTO.setCity(address.getCity());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setLandmark(address.getLandmark());
        addressDTO.setState(address.getState());
        addressDTO.setPincode(address.getPincode());
        return addressDTO;
    }

    public static UserDTO entityToDTO(User user) {
        if (user == null) {
            return null;
        }

        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setUserFirstName(user.getUserFirstName());
        userDTO.setUserLastName(user.getUserLastName());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setUserEmail(user.getUserEmail());
        userDTO.setUserPassword(user.getUserPassword());
        userDTO.setRoles(user.getRoles());

        Set<Address> addresses = user.getAddress();
        if (addresses != null) {
            Set<AddressDTO> addressDTOS = new HashSet<>();
            for (Address address : addresses) {
                AddressDTO addressDTO = entityToDTO(address);
                if (addressDTO != null) {
                    addressDTOS.add(addressDTO);
                }
            }
            userDTO.setAddress(addressDTOS);
        } else {
            userDTO.setAddress(null);
        }
        return userDTO;
    }

    private Address updateAddress(AddressDTO addressDTO) {
        Optional<Address> optional = addressRepository.findById(addressDTO.getAddressId());
        if (optional.isPresent()){
            Address address = optional.get();
            address.setPincode(addressDTO.getPincode());
            address.setStreet(addressDTO.getStreet());
            address.setCity(addressDTO.getCity());
            address.setState(addressDTO.getState());
            address.setLandmark(addressDTO.getLandmark());
            address.setHouseNo(addressDTO.getHouseNo());
            return address;
        }
        else{
            Address address=dtoToEntity(addressDTO);
            return addressRepository.save(address);
        }
    }


}
