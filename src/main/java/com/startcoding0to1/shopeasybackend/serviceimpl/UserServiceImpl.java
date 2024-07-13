package com.startcoding0to1.shopeasybackend.serviceimpl;

import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.dto.*;
import com.startcoding0to1.shopeasybackend.entity.*;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.repository.*;
import com.startcoding0to1.shopeasybackend.service.UserService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
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
    private CustomerDetailsRepository customerDetailsRepository;
    @Autowired
    private SellerDetailsRepository sellerDetailsRepository;
    @Autowired
    private AdminDetailsRepository adminDetailsRepository;
    private static final DateTimeFormatter DATETIMEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private ModelMapper MODELMAPPER;
    @Override
    public AuthResponse registerUser(UserDTO userDTO) throws ShopEasyException {
        Optional<User> optional = userRepository.findByUserEmail(userDTO.getUserEmail());
        if (optional.isPresent()) {
            throw new ShopEasyException(ShopEasyConstants.RECORD_ALREADY_EXIST +optional.get().getUserId()+" " +"("+userDTO.getUserEmail()+")", HttpStatus.CONFLICT);
        }
        if(userDTO.getRoles()==null){
            userDTO.setRoles(Set.of(Role.CUSTOMER));
        }
        User user = MODELMAPPER.map(userDTO, User.class);
        user.setCreationTime(LocalDateTime.parse(LocalDateTime.now().format(DATETIMEFORMATTER), DATETIMEFORMATTER));
        user.setLastUpdateTime(LocalDateTime.parse(LocalDateTime.now().format(DATETIMEFORMATTER), DATETIMEFORMATTER));
        user = userRepository.save(user);
        userDTO.setUserId(user.getUserId());
        userDTO.setCreationTime(user.getCreationTime().format(DATETIMEFORMATTER));
        userDTO.setLastUpdateTime(user.getLastUpdateTime().format(DATETIMEFORMATTER));
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
        UserDTO userDTO=MODELMAPPER.map(user,UserDTO.class);
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
            UserDTO userDTO = MODELMAPPER.map(user,UserDTO.class);
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
        User user=optional.orElseThrow(()-> new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_USER_ID+userId,HttpStatus.NOT_FOUND));
        UserDTO userDTO=MODELMAPPER.map(user,UserDTO.class);
        return userDTO;
    }
    @Override
    public String updateUser(String userId, UserDTO userDTO) throws ShopEasyException {
        Optional<User> optional=userRepository.findById(userId);
        User user=optional.orElseThrow(() -> new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_USER_ID+userId,HttpStatus.NOT_FOUND));
        user.setUserFirstName(userDTO.getUserFirstName()!=null?userDTO.getUserFirstName():user.getUserFirstName());
        user.setUserLastName(userDTO.getUserLastName()!=null?userDTO.getUserLastName():user.getUserLastName());
        user.setUserEmail(userDTO.getUserEmail()!=null?userDTO.getUserEmail():user.getUserEmail());
        user.setRoles(userDTO.getRoles()!=null?userDTO.getRoles():user.getRoles());
        user.setUserPassword(userDTO.getUserPassword()!=null?userDTO.getUserPassword():user.getUserPassword());
        user.setPhoneNumber(userDTO.getPhoneNumber()!=null?userDTO.getPhoneNumber():user.getPhoneNumber());
        user.setLastUpdateTime(LocalDateTime.parse(LocalDateTime.now().format(DATETIMEFORMATTER),DATETIMEFORMATTER));
        userRepository.save(user);
        return ShopEasyConstants.RECORD_SUCCESSFULLY_UPDATED+userId;
    }

    @Override
    public String deleteUser(String userId) throws ShopEasyException {
        Optional<User> optional=userRepository.findById(userId);
        User user=optional.orElseThrow(()->new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_USER_ID+userId,HttpStatus.NOT_FOUND));
        UserDTO userDTO=new UserDTO();
        userDTO.setUserId(user.getUserId());
        userRepository.deleteById(user.getUserId());
        return ShopEasyConstants.RECORD_SUCCESSFULLY_DELETED+userId;
    }
}
