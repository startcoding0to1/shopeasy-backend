package com.startcoding0to1.shopeasybackend.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.dto.ProductsDTO;
import com.startcoding0to1.shopeasybackend.service.ProductsService;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {

	@Autowired
	ProductsService productsService;

	@GetMapping(value = "/all")
	public ResponseEntity<List<ProductsDTO>> getAllProducts() throws ShopEasyException {
		List<ProductsDTO> products = null;
		try {
			products = productsService.getAllProducts();
			return new ResponseEntity<>(products, HttpStatus.OK);
		} catch (ShopEasyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception");
			return new ResponseEntity<>(products, HttpStatus.NOT_FOUND);
		}

	}
}