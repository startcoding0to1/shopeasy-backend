package com.startcoding0to1.shopeasybackend.serviceimpl;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.dto.WishlistDTO;
import com.startcoding0to1.shopeasybackend.entity.CustomerDetails;
import com.startcoding0to1.shopeasybackend.entity.Product;
import com.startcoding0to1.shopeasybackend.entity.Wishlist;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.repository.CustomerDetailsRepository;
import com.startcoding0to1.shopeasybackend.repository.ProductsRepository;
import com.startcoding0to1.shopeasybackend.repository.WishlistRepository;
import com.startcoding0to1.shopeasybackend.service.WishlistService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;
    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private ModelMapper MODELMAPPER;

    @SuppressWarnings("unused")
	@Override
    public Set<WishlistDTO> getAllWishlistItems(Integer customerDetailsId) throws ShopEasyException {
        Optional<CustomerDetails> optional = customerDetailsRepository.findById(customerDetailsId);
        CustomerDetails customerDetails = optional.orElseThrow(()->new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_CUSTOMER_DETAILS_ID+customerDetailsId,HttpStatus.NOT_FOUND));
        Set<Wishlist> wishlists = wishlistRepository.findByCustomerDetails(customerDetails);
        Set<WishlistDTO>  wishlistDTOS = new HashSet<WishlistDTO>();
        for (Wishlist wishlist:wishlists){
            WishlistDTO wishlistDTO = MODELMAPPER.map(wishlist,WishlistDTO.class);
            wishlistDTOS.add(wishlistDTO);
        }
        if(wishlistDTOS == null){
            throw new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND, HttpStatus.NOT_FOUND);
        }
        return wishlistDTOS;
    }

    @Override
    public String addWishlistitem(WishlistDTO wishlistDTO) throws ShopEasyException {
        CustomerDetails customerDetails = getCustomerDetails(wishlistDTO.getCustomerDetailsId());
        Product product =  getProduct(wishlistDTO.getProductId());
        Set<Wishlist> wishlists = wishlistRepository.findByCustomerDetailsAndProduct(customerDetails,product);
        if (!wishlists.isEmpty()){
            throw new ShopEasyException(ShopEasyConstants.RECORD_ALREADY_EXIST+wishlistDTO.getWishlistId(),HttpStatus.CONFLICT);
        }
        Wishlist wishlist = MODELMAPPER.map(wishlistDTO,Wishlist.class);
        wishlist.setCreationTime(LocalDateTime.now());
        wishlist=wishlistRepository.save(wishlist);
        return ShopEasyConstants.RECORD_SUCCESSFULLY_ADDED+wishlist.getWishlistId();
    }

    @Override
    public String deleteWishlistitem(Integer wishlistId) throws ShopEasyException {
        Optional<Wishlist> optional = wishlistRepository.findById(wishlistId);
        Wishlist wishlist = optional.orElseThrow(()->new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_WISHLIST_ID+wishlistId,HttpStatus.NOT_FOUND));
        wishlistRepository.deleteByWishlistId(wishlistId);
        return ShopEasyConstants.RECORD_SUCCESSFULLY_DELETED+wishlist.getWishlistId();
    }

    private CustomerDetails getCustomerDetails(Integer customerDetailsId) throws ShopEasyException {
        Optional<CustomerDetails> optional = customerDetailsRepository.findById(customerDetailsId);
        CustomerDetails customerDetails = optional.orElseThrow(()->new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_CUSTOMER_DETAILS_ID+customerDetailsId,HttpStatus.NOT_FOUND));
        return customerDetails;
    }
    private Product getProduct(String productId) throws ShopEasyException {
        Optional<Product> optional = productsRepository.findById(productId);
        Product product = optional.orElseThrow(()->new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_PRODUCT_ID+productId,HttpStatus.NOT_FOUND));
        return product;
    }
}
