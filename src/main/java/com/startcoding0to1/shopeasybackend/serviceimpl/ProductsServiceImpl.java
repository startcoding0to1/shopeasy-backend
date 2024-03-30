package com.startcoding0to1.shopeasybackend.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.dto.ProductsDTO;
import com.startcoding0to1.shopeasybackend.entity.Products;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.repository.ProductsRepository;
import com.startcoding0to1.shopeasybackend.service.ProductsService;

import jakarta.transaction.Transactional;

/**
 * Implementation of the ProductsService interface for managing product-related operations.
 * 
 * @author Mahammad Khairuddin
 */


@Service(value = "ProductsService")
@Transactional
public class ProductsServiceImpl implements ProductsService {
	
	@Autowired
	ProductsRepository productsRepository;
	
	@Autowired
	Products products;

	@Override
	public List<ProductsDTO> getAllProducts() throws ShopEasyException {
		Iterable<Products> listproducts = productsRepository.findAll();
		List<ProductsDTO> listProductsDTO = new ArrayList<>();
		listproducts.forEach(products -> {
			ProductsDTO productsDTO = new ProductsDTO(products);
			listProductsDTO.add(productsDTO);
		});
		if(listProductsDTO.isEmpty()) {
			throw new ShopEasyException(ShopEasyConstants.NO_PRODUCTS_FOUND);
		}
		return listProductsDTO;
	}

	@Override
	public ProductsDTO getProductById(String prodId) throws ShopEasyException {
		Optional<Products> optional = productsRepository.findById(prodId);
		Products products = optional.orElseThrow(() -> new ShopEasyException(ShopEasyConstants.No_RECORDS_FOUND_FOR + prodId));
		ProductsDTO productsDTO = new ProductsDTO(products);
		return productsDTO;
	}

	@Override
	public String addProduct(ProductsDTO productsDTO) throws ShopEasyException {
		Optional<Products> optional = productsRepository.findByProductNameAndProdCategoryAndManufacturerAndBrandAndBarcode(productsDTO.getProductName(),
						productsDTO.getProdCategory(), productsDTO.getManufacturer(), productsDTO.getBrand(),
						productsDTO.getBarcode());
		String message = ShopEasyConstants.RECORD_ALREADY_EXIST;
		if(optional.isPresent()) {
			return message + optional.get().getProductId();
		}
		Products products;
		message = ShopEasyConstants.RECORD_SUCCESSFULLY_ADDED;
		products = new Products(productsDTO);
		Products saved = productsRepository.save(products);
		return message + saved.getProductId();
	}

	@Override
	public String updateProduct(String prodId, ProductsDTO productsDTO) throws ShopEasyException {
		Optional<Products> optional = productsRepository.findById(productsDTO.getProductId());
		Products products = optional.orElseThrow(() -> new ShopEasyException(ShopEasyConstants.No_RECORDS_FOUND_FOR + productsDTO.getProductId()));
		products.updateProducts(productsDTO, products);
		Products saved = productsRepository.save(products);
		return ShopEasyConstants.RECORD_SUCCESSFULLY_UPDATED + saved.getProductId();
	}
	
	@Override
	public String deleteProduct(String prodId) throws ShopEasyException {
		Optional<Products> optional = productsRepository.findById(prodId);
		optional.orElseThrow(() -> new ShopEasyException(ShopEasyConstants.No_RECORDS_FOUND_FOR + prodId));
		productsRepository.deleteById(prodId);
		return ShopEasyConstants.RECORD_SUCCESSFULLY_DELETED + prodId; 
	}
}
