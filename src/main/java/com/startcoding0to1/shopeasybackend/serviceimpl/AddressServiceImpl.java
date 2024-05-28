package com.startcoding0to1.shopeasybackend.serviceimpl;

import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.dto.AddressDTO;
import com.startcoding0to1.shopeasybackend.dto.UserDTO;
import com.startcoding0to1.shopeasybackend.entity.Address;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.repository.AddressRepository;
import com.startcoding0to1.shopeasybackend.service.AddressService;
import jakarta.transaction.Transactional;
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

    @Override
    public Set<AddressDTO> getAllUserAddresses(UserDTO userId) {
        Set<Address> addresses = addressRepository.findByUserId(userId);
        Set<AddressDTO> addressDTOS = new HashSet<AddressDTO>();
        addresses.forEach(address -> {
            AddressDTO addressDTO=entityToDTO(address);
            addressDTOS.add(addressDTO);
        });
        if(addressDTOS==null){
            return null;
        }
        return addressDTOS;
    }

    @Override
    public String addAddress(AddressDTO addressDTO) throws ShopEasyException {
        Optional<Address> optional = addressRepository.findByHouseNoAndStreet(addressDTO.getHouseNo(),addressDTO.getStreet());
        optional.orElseThrow(() -> new ShopEasyException(ShopEasyConstants.RECORD_ALREADY_EXIST+addressDTO.getAddressId(),HttpStatus.CONFLICT));
        Address address = dtoToEntity(addressDTO);
        address=addressRepository.save(address);
        return ShopEasyConstants.RECORD_SUCCESSFULLY_ADDED+address.getAddressId();
    }

    @Override
    public String updateAddress(Integer addressId, AddressDTO addressDTO) throws ShopEasyException {
        Optional<Address> optional = addressRepository.findById(addressDTO.getAddressId());
        Address address = optional.orElseThrow(()->new ShopEasyException(ShopEasyConstants.No_RECORDS_FOUND_FOR_ADDRESS_ID+addressId, HttpStatus.NOT_FOUND));
        address.setPincode(addressDTO.getPincode());
        address.setStreet(addressDTO.getStreet());
        address.setCity(addressDTO.getCity());
        address.setState(addressDTO.getState());
        address.setLandmark(addressDTO.getLandmark());
        address.setHouseNo(addressDTO.getHouseNo());
        return ShopEasyConstants.RECORD_SUCCESSFULLY_UPDATED+address.getAddressId();
    }

    @Override
    public String deleteAddress(Integer addressId) throws ShopEasyException {
        Optional<Address> optional = addressRepository.findById(addressId);
        Address address = optional.orElseThrow(()->new ShopEasyException(ShopEasyConstants.No_RECORDS_FOUND_FOR_ADDRESS_ID+addressId, HttpStatus.NOT_FOUND));
        addressRepository.deleteById(addressId);
        return ShopEasyConstants.RECORD_SUCCESSFULLY_DELETED+addressId;
    }

    private static AddressDTO entityToDTO(Address address) {
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

    private static Address dtoToEntity(AddressDTO addressDTO){
        Address address=new Address();
        address.setHouseNo(addressDTO.getHouseNo());
        address.setCity(addressDTO.getCity());
        address.setStreet(addressDTO.getStreet());
        address.setLandmark(addressDTO.getLandmark());
        address.setState(addressDTO.getState());
        address.setPincode(addressDTO.getPincode());
        return address;
    }

}
