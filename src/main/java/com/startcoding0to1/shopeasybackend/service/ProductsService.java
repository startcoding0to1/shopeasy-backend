package com.startcoding0to1.shopeasybackend.service;

import java.util.List;

import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.dto.ProductsDTO;

public interface ProductsService {
	public List<ProductsDTO> getAllProducts() throws ShopEasyException;
}