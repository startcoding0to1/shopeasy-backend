package com.startcoding0to1.shopeasybackend.serviceimpl;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.startcoding0to1.shopeasybackend.entity.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.dto.ProductDTO;
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
	public List<ProductDTO> getAllProducts() throws ShopEasyException {
		Iterable<Product> listproducts = productsRepository.findAll();
		List<ProductDTO> listProductsDTO = new ArrayList<>();
		listproducts.forEach(products -> {
			ProductDTO productsDTO=modelMapper.map(products, ProductDTO.class);
			listProductsDTO.add(productsDTO);
		});
		if(listProductsDTO.isEmpty()) {
			throw new ShopEasyException(ShopEasyConstants.NO_PRODUCTS_FOUND, HttpStatus.NOT_FOUND);
		}
		return listProductsDTO;
	}

	@Override
	public ProductDTO getProductById(String prodId) throws ShopEasyException {
		Optional<Product> optional = productsRepository.findById(prodId);
		Product products = optional.orElseThrow(() -> new ShopEasyException(ShopEasyConstants.No_RECORDS_FOUND_FOR_PRODUCT_ID + prodId,HttpStatus.NOT_FOUND));
		ProductDTO productsDTO=modelMapper.map(products, ProductDTO.class);
		return productsDTO;
	}

	@Override
	public String addProduct(ProductDTO productsDTO) throws ShopEasyException {
		Optional<Product> optional = productsRepository.findByProductNameAndProdCategoryAndProdSubCategoryAndSellerAndBrand(productsDTO.getProductName(),
						productsDTO.getProdCategory(), productsDTO.getProdSubCategory(),productsDTO.getSeller(), productsDTO.getBrand());
		if(optional.isPresent()) {
			throw new ShopEasyException(ShopEasyConstants.RECORD_ALREADY_EXIST + optional.get().getProductId(),HttpStatus.CONFLICT);
		}
		Product product;
		product=modelMapper.map(productsDTO, Product.class);
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String currentTime=localDateTime.format(dateTimeFormatter);
		product.setCreationTime(LocalDateTime.parse(currentTime,dateTimeFormatter));
		product.setLastUpdateTime(LocalDateTime.parse(currentTime,dateTimeFormatter));
		Product saved = productsRepository.save(product);
		return ShopEasyConstants.RECORD_SUCCESSFULLY_ADDED + saved.getProductId();
	}

	@Override
	public String updateProduct(String prodId, ProductDTO productsDTO) throws Exception{
		Optional<Product> optional = productsRepository.findById(prodId);
		Product product = optional.orElseThrow(() -> new ShopEasyException(ShopEasyConstants.No_RECORDS_FOUND_FOR_PRODUCT_ID + prodId,HttpStatus.NOT_FOUND));
		updateProductData(productsDTO, product);
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String currentTime=localDateTime.format(dateTimeFormatter);
		product.setLastUpdateTime(LocalDateTime.parse(currentTime,dateTimeFormatter));
		return ShopEasyConstants.RECORD_SUCCESSFULLY_UPDATED + product.getProductId();
	}

	/**
	 * Updates the product details based on the provided DTO.
	 *
	 * @param productsDTO The DTO containing updated product information.
	 * @return The updated Products entity.
	 * @author Mahammad Khairuddin
	 */
	public static void updateProductData(ProductDTO productsDTO, Product product) throws Exception{
		Field[] fieldsDto = ProductDTO.class.getDeclaredFields();

		for (Field fieldDto : fieldsDto) {
			try {
				fieldDto.setAccessible(true);
				String fieldName = fieldDto.getName();
				Object value = fieldDto.get(productsDTO);
				if (fieldName != "productId" || fieldName !="creationTime" || fieldName !="lastUpdateTime") {
					Field field = Product.class.getDeclaredField(fieldName);
					field.setAccessible(true);
					field.set(product, value);
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
		Optional<Product> optional = productsRepository.findById(prodId);
		optional.orElseThrow(() -> new ShopEasyException(ShopEasyConstants.No_RECORDS_FOUND_FOR_PRODUCT_ID + prodId,HttpStatus.NOT_FOUND));
		productsRepository.deleteById(prodId);
		return ShopEasyConstants.RECORD_SUCCESSFULLY_DELETED + prodId;
	}
}
