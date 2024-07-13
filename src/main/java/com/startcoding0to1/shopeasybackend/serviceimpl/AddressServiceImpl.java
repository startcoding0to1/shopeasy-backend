package com.startcoding0to1.shopeasybackend.serviceimpl;

import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.dto.AddressDTO;
import com.startcoding0to1.shopeasybackend.dto.AdminDetailsDTO;
import com.startcoding0to1.shopeasybackend.dto.UserDTO;
import com.startcoding0to1.shopeasybackend.entity.*;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.repository.*;
import com.startcoding0to1.shopeasybackend.service.AddressService;
import com.startcoding0to1.shopeasybackend.service.UserService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AdminDetailsRepository adminDetailsRepository;
    @Autowired
    private SellerDetailsRepository sellerDetailsRepository;
    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;
    @Autowired
    private ModelMapper MODELMAPPER;

    @Override
    public Set<AddressDTO> getAllUserAddresses(Integer userDetailsId,String userId,String typeOfUser) throws ShopEasyException {
        Optional<User> optional = userRepository.findById(userId);
        User user = optional.orElseThrow(()->new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_USER_ID+userId,HttpStatus.NOT_FOUND));
        Set<Address> addresses = null;
        switch (typeOfUser){
            case "admin":
                Optional<AdminDetails> optional1 = adminDetailsRepository.findById(userDetailsId);
                AdminDetails adminDetails = optional1.orElseThrow(()->new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_ADMIN_DETAILS_ID+userDetailsId,HttpStatus.NOT_FOUND));
                addresses = addressRepository.findByUserAndAdminDetails(user,adminDetails);
                break;
            case "seller":
                Optional<SellerDetails> optional2 = sellerDetailsRepository.findById(userDetailsId);
                SellerDetails sellerDetails = optional2.orElseThrow(()->new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_SELLER_DETAILS_ID+userDetailsId,HttpStatus.NOT_FOUND));
                addresses = addressRepository.findByUserAndSellerDetails(user,sellerDetails);
                break;
            case "customer":
                Optional<CustomerDetails> optional3 = customerDetailsRepository.findById(userDetailsId);
                CustomerDetails customerDetails = optional3.orElseThrow(()->new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_CUSTOMER_DETAILS_ID+userDetailsId,HttpStatus.NOT_FOUND));
                addresses = addressRepository.findByUserAndCustomerDetails(user,customerDetails);
                break;
        }
        Set<AddressDTO> addressDTOS = new HashSet<AddressDTO>();
        addresses.forEach(address -> {
            AddressDTO addressDTO=MODELMAPPER.map(address,AddressDTO.class);
            addressDTOS.add(addressDTO);
        });
        if(addressDTOS==null){
            return null;
        }
        return addressDTOS;
    }

    @Override
    public String addAddress(AddressDTO addressDTO,String typeOfUser) throws ShopEasyException {
        if(addressDTO.getUserId()==null){
            throw new ShopEasyException(ShopEasyConstants.USER_INFO_MISSING_IN_ADDRESS,HttpStatus.BAD_REQUEST);
        }
        Address address = MODELMAPPER.map(addressDTO,Address.class);
        switch (typeOfUser.toLowerCase()){
            case "admin":
                Optional<AdminDetails> optional3 = adminDetailsRepository.findById(addressDTO.getAdminId());
                AdminDetails adminDetails = optional3.orElseThrow(()->new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_ADMIN_DETAILS_ID+addressDTO.getAdminId(),HttpStatus.NOT_FOUND));
                Optional<Address> optional1 = addressRepository.findByHouseNoAndStreetAndAdminDetails(addressDTO.getHouseNo(),addressDTO.getStreet(),adminDetails);
                if(optional1.isPresent()){
                    throw new ShopEasyException(ShopEasyConstants.RECORD_ALREADY_EXIST+optional1.get().getAddressId(),HttpStatus.CONFLICT);
                }
                address.setAdminDetails(adminDetails);
                break;
            case "seller":
                Optional<SellerDetails> optional4 = sellerDetailsRepository.findById(addressDTO.getSellerId());
                SellerDetails sellerDetails = optional4.orElseThrow(()->new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_SELLER_DETAILS_ID+addressDTO.getSellerId(),HttpStatus.NOT_FOUND));
                Optional<Address> optional2 = addressRepository.findByHouseNoAndStreetAndSellerDetails(addressDTO.getHouseNo(),addressDTO.getStreet(),sellerDetails);
                if(optional2.isPresent()){
                    throw new ShopEasyException(ShopEasyConstants.RECORD_ALREADY_EXIST+optional2.get().getAddressId(),HttpStatus.CONFLICT);
                }
                address.setSellerDetails(sellerDetails);
                break;
            case "customer":
                Optional<CustomerDetails> optional5 = customerDetailsRepository.findById(addressDTO.getCustomerId());
                CustomerDetails customerDetails = optional5.orElseThrow(()->new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_CUSTOMER_DETAILS_ID+addressDTO.getCustomerId(),HttpStatus.NOT_FOUND));
                Optional<Address> optional6 = addressRepository.findByHouseNoAndStreetAndCustomerDetails(addressDTO.getHouseNo(),addressDTO.getStreet(),customerDetails);
                if(optional6.isPresent()){
                    throw new ShopEasyException(ShopEasyConstants.RECORD_ALREADY_EXIST+optional6.get().getAddressId(),HttpStatus.CONFLICT);
                }
                address.setCustomerDetails(customerDetails);
                break;
        }
        Optional<User> optional2 = userRepository.findById(addressDTO.getUserId());
        User user = optional2.orElseThrow(()->new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_USER_ID+addressDTO.getUserId(),HttpStatus.NOT_FOUND));
        address.setUser(user);
        address=addressRepository.save(address);
        return ShopEasyConstants.RECORD_SUCCESSFULLY_ADDED+address.getAddressId();
    }

    @Override
    public String updateAddress(Integer addressId, AddressDTO addressDTO) throws ShopEasyException {
        Optional<Address> optional = addressRepository.findById(addressId);
        Address address = optional.orElseThrow(()->new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_ADDRESS_ID+addressId, HttpStatus.NOT_FOUND));
        address.setPincode(addressDTO.getPincode()!=null?addressDTO.getPincode():address.getPincode());
        address.setStreet(addressDTO.getStreet()!=null?addressDTO.getStreet():address.getStreet());
        address.setCity(addressDTO.getCity()!=null?addressDTO.getCity():address.getCity());
        address.setState(addressDTO.getState()!=null?addressDTO.getState():address.getState());
        address.setLandmark(addressDTO.getLandmark()!=null?addressDTO.getLandmark():address.getLandmark());
        address.setHouseNo(addressDTO.getHouseNo()!=null?addressDTO.getHouseNo():address.getHouseNo());
        address.setSellerDetails(addressDTO.getSellerId()!=null?sellerDetailsRepository.findById(addressDTO.getSellerId()).get():null);
        address.setCustomerDetails(addressDTO.getCustomerId()!=null?customerDetailsRepository.findById(addressDTO.getCustomerId()).get():null);
        address.setAdminDetails(addressDTO.getAdminId()!=null?adminDetailsRepository.findById(addressDTO.getAdminId()).get():null);
        addressRepository.save(address);
        return ShopEasyConstants.RECORD_SUCCESSFULLY_UPDATED+address.getAddressId();
    }

    @Override
    public String deleteAddress(Integer addressId) throws ShopEasyException {
        Optional<Address> optional = addressRepository.findById(addressId);
        Address address = optional.orElseThrow(()->new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_ADDRESS_ID+addressId, HttpStatus.NOT_FOUND));
        addressRepository.deleteById(addressId);
        return ShopEasyConstants.RECORD_SUCCESSFULLY_DELETED+addressId;
    }
}
