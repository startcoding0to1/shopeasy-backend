package com.startcoding0to1.shopeasybackend.serviceimpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.dto.AuthRequest;
import com.startcoding0to1.shopeasybackend.dto.AuthResponse;
import com.startcoding0to1.shopeasybackend.dto.SuccessResponse;
import com.startcoding0to1.shopeasybackend.dto.UserDTO;
import com.startcoding0to1.shopeasybackend.entity.Role;
import com.startcoding0to1.shopeasybackend.entity.User;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.repository.UserRepository;
import com.startcoding0to1.shopeasybackend.service.UserService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
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
	public SuccessResponse uploadImg(String userId,byte[] profileImg) throws ShopEasyException {
		UserDTO userDTO = new UserDTO();
		userDTO.setProfilepic(profileImg);
		return updateUser(userId,userDTO);
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

    @SuppressWarnings("unused")
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
    public SuccessResponse updateUser(String userId, UserDTO userDTO) throws ShopEasyException {
        Optional<User> optional=userRepository.findById(userId);
        User user=optional.orElseThrow(() -> new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_USER_ID+userId,HttpStatus.NOT_FOUND));
        if(userDTO.getProfilepic()!=null && userDTO.getProfilepic().length > 0) {
        	user.setProfilepic(userDTO.getProfilepic());
        }else {
        	user.setProfilepic(user.getProfilepic());
        	user.setUserFirstName(validate(userDTO.getUserFirstName())?userDTO.getUserFirstName():user.getUserFirstName());
            user.setUserLastName(userDTO.getUserLastName());
            user.setUserEmail(validate(userDTO.getUserEmail())?userDTO.getUserEmail():user.getUserEmail());
            user.setRoles((userDTO.getRoles()!=null && !userDTO.getRoles().isEmpty())?userDTO.getRoles():user.getRoles());
            user.setUserPassword(validate(userDTO.getUserPassword())?userDTO.getUserPassword():user.getUserPassword());
            user.setPhoneNumber(userDTO.getPhoneNumber()!=null?userDTO.getPhoneNumber():user.getPhoneNumber());
            user.setLastUpdateTime(LocalDateTime.parse(LocalDateTime.now().format(DATETIMEFORMATTER),DATETIMEFORMATTER));
        }
        userRepository.save(user);
        return new SuccessResponse(userId,ShopEasyConstants.RECORD_SUCCESSFULLY_UPDATED+userId);
    }
    
    static boolean validate(String val){
    	return val != null && !val.isBlank() && !val.isEmpty();
    }

    @Override
    public SuccessResponse deleteUser(String userId) throws ShopEasyException {
        Optional<User> optional=userRepository.findById(userId);
        User user=optional.orElseThrow(()->new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_USER_ID+userId,HttpStatus.NOT_FOUND));
        UserDTO userDTO=new UserDTO();
        userDTO.setUserId(user.getUserId());
        userRepository.deleteById(user.getUserId());
        return new SuccessResponse(userId,ShopEasyConstants.RECORD_SUCCESSFULLY_DELETED);
    }
}
