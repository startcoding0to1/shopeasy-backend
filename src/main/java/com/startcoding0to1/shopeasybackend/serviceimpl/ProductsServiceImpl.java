package com.startcoding0to1.shopeasybackend.serviceimpl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.startcoding0to1.shopeasybackend.entity.Products;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.dto.ProductsDTO;
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

	private static final ModelMapper modelMapper = new ModelMapper();

	@Override
	public List<ProductsDTO> getAllProducts() throws ShopEasyException {
		Iterable<Products> listproducts = productsRepository.findAll();
		List<ProductsDTO> listProductsDTO = new ArrayList<>();
		listproducts.forEach(products -> {
			ProductsDTO productsDTO=modelMapper.map(products,ProductsDTO.class);
			listProductsDTO.add(productsDTO);
		});
		if(listProductsDTO.isEmpty()) {
			throw new ShopEasyException(ShopEasyConstants.NO_PRODUCTS_FOUND, HttpStatus.NOT_FOUND);
		}
		return listProductsDTO;
	}

	@Override
	public ProductsDTO getProductById(String prodId) throws ShopEasyException {
		Optional<Products> optional = productsRepository.findById(prodId);
		Products products = optional.orElseThrow(() -> new ShopEasyException(ShopEasyConstants.No_RECORDS_FOUND_FOR + prodId,HttpStatus.NOT_FOUND));
		ProductsDTO productsDTO=modelMapper.map(products,ProductsDTO.class);
		return productsDTO;
	}

	@Override
	public String addProduct(ProductsDTO productsDTO) throws ShopEasyException {
		Optional<Products> optional = productsRepository.findByProductNameAndProdCategoryAndSellerAndBrand(productsDTO.getProductName(),
						productsDTO.getProdCategory(), productsDTO.getSeller(), productsDTO.getBrand());
		if(optional.isPresent()) {
			throw new ShopEasyException(ShopEasyConstants.RECORD_ALREADY_EXIST + optional.get().getProductId(),HttpStatus.CONFLICT);
		}
		Products products;
		products=modelMapper.map(productsDTO,Products.class);
		Products saved = productsRepository.save(products);
		return ShopEasyConstants.RECORD_SUCCESSFULLY_ADDED + saved.getProductId();
	}

	@Override
	public String updateProduct(String prodId, ProductsDTO productsDTO) throws Exception{
		Optional<Products> optional = productsRepository.findById(prodId);
		Products products = optional.orElseThrow(() -> new ShopEasyException(ShopEasyConstants.No_RECORDS_FOUND_FOR + prodId,HttpStatus.NOT_FOUND));
		updateProducts(productsDTO, products);
		Products saved = productsRepository.save(products);
		return ShopEasyConstants.RECORD_SUCCESSFULLY_UPDATED + saved.getProductId();
	}

	/**
	 * Updates the product details based on the provided DTO.
	 *
	 * @param productsDTO The DTO containing updated product information.
	 * @return The updated Products entity.
	 * @author Mahammad Khairuddin
	 */
	public void updateProducts(ProductsDTO productsDTO, Products products) throws Exception{
		Field[] fieldsDto = ProductsDTO.class.getDeclaredFields();

		for (Field fieldDto : fieldsDto) {
			try {
				fieldDto.setAccessible(true);
				String fieldName = fieldDto.getName();
				Object value = fieldDto.get(productsDTO);
				if (fieldName != "productId") {
					Field field = Products.class.getDeclaredField(fieldName);
					field.setAccessible(true);
					field.set(products, value);
				}

			} catch (IllegalAccessException e) {
				throw new ShopEasyException(e.getMessage(),HttpStatus.FORBIDDEN);
			}
			catch(NoSuchFieldException e){
				throw new ShopEasyException(e.getMessage(),HttpStatus.NOT_FOUND);
			}
			catch(Exception e){
				throw new Exception(e.getMessage());
			}
		}
	}
	
	@Override
	public String deleteProduct(String prodId) throws ShopEasyException {
		Optional<Products> optional = productsRepository.findById(prodId);
		optional.orElseThrow(() -> new ShopEasyException(ShopEasyConstants.No_RECORDS_FOUND_FOR + prodId,HttpStatus.NOT_FOUND));
		productsRepository.deleteById(prodId);
		return ShopEasyConstants.RECORD_SUCCESSFULLY_DELETED + prodId; 
	}
}
