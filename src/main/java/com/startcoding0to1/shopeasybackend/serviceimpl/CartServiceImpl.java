package com.startcoding0to1.shopeasybackend.serviceimpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.dto.CartDTO;
import com.startcoding0to1.shopeasybackend.entity.Cart;
import com.startcoding0to1.shopeasybackend.entity.CustomerDetails;
import com.startcoding0to1.shopeasybackend.entity.Product;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.repository.CartRepository;
import com.startcoding0to1.shopeasybackend.repository.CustomerDetailsRepository;
import com.startcoding0to1.shopeasybackend.repository.ProductsRepository;
import com.startcoding0to1.shopeasybackend.service.CartService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CustomerDetailsRepository customerDetailsRepository;
    @Autowired
    private ProductsRepository productsRepository;
    private static final ModelMapper MODELMAPPER = new ModelMapper();

    @SuppressWarnings("unused")
	@Override
    public Set<CartDTO> getAllCartItems(Integer customerDetailsId) throws ShopEasyException {
        CustomerDetails customerDetails = getCustomerDetails(customerDetailsId);
        List<Cart> carts = cartRepository.findByCustomerDetails(customerDetails);
        Set<CartDTO> cartDTOS = new HashSet<CartDTO>();
        for (Cart cart:carts){
            CartDTO cartDTO = MODELMAPPER.map(cart,CartDTO.class);
            cartDTO.setCreationTime(cart.getCreationTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            cartDTOS.add(cartDTO);
        }
        if(cartDTOS == null){
            throw new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND, HttpStatus.NOT_FOUND);
        }
        return cartDTOS;
    }

    @Override
    public String addCartItem(CartDTO cartDTO) throws ShopEasyException {
        CustomerDetails customerDetails = getCustomerDetails(cartDTO.getCustomerDetailsId());
        Product products =  getProduct(cartDTO.getProductId());
        List<Cart> carts = cartRepository.findByProductAndCustomerDetails(products,customerDetails);
        if (!carts.isEmpty()){
            throw new ShopEasyException(ShopEasyConstants.RECORD_ALREADY_EXIST+carts.get(0).getCartId(),HttpStatus.CONFLICT);
        }
        Cart cart = MODELMAPPER.map(cartDTO,Cart.class);
        cart.setCreationTime(LocalDateTime.now());
        cart = cartRepository.save(cart);
        return ShopEasyConstants.RECORD_SUCCESSFULLY_ADDED+cart.getCartId();
    }

    @Override
    public String updateCartItem(Integer cartId, CartDTO cartDTO) throws ShopEasyException {
        Cart cart = getCart(cartId);

        if (cartDTO.getQuantity() != null) {
            cart.setQuantity(cartDTO.getQuantity());
        }

        if (cartDTO.getCustomerDetailsId() != null) {
            CustomerDetails customerDetails = getCustomerDetails(cartDTO.getCustomerDetailsId());
            cart.setCustomerDetails(customerDetails);
        }

        if (cartDTO.getProductId() != null) {
            Product product = getProduct(cartDTO.getProductId());
            cart.setProduct(product);
        }
        cart.setCreationTime(LocalDateTime.now());
        cartRepository.save(cart);

        return ShopEasyConstants.RECORD_SUCCESSFULLY_UPDATED + cartId;
    }


    @Override
    public String deleteCartItem(Integer cartId) throws ShopEasyException {
        Cart cart = getCart(cartId);
        cartRepository.deleteByCartId(cart.getCartId());
        return ShopEasyConstants.RECORD_SUCCESSFULLY_DELETED+cartId;
    }

    private Cart getCart(Integer cartId) throws ShopEasyException {
        Optional<Cart> optional = cartRepository.findById(cartId);
        Cart cart = optional.orElseThrow(()-> new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_CART_ID+cartId,HttpStatus.NOT_FOUND));
        return cart;
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
