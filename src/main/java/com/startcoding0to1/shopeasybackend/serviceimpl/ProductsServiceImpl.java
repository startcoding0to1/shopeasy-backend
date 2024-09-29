package com.startcoding0to1.shopeasybackend.serviceimpl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.dto.ProductDTO;
import com.startcoding0to1.shopeasybackend.entity.Product;
import com.startcoding0to1.shopeasybackend.entity.SellerDetails;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.repository.ProductsRepository;
import com.startcoding0to1.shopeasybackend.repository.SellerDetailsRepository;
import com.startcoding0to1.shopeasybackend.service.ProductsService;

/**
 * Implementation of the ProductsService interface for managing product-related operations.
 * 
 * @author Mahammad Khairuddin
 */


@Service(value = "productsService")
@Transactional
public class ProductsServiceImpl implements ProductsService {
	
	@Autowired
	private ProductsRepository productsRepository;
	@Autowired
	private SellerDetailsRepository sellerDetailsRepository;
	@Autowired
	private ModelMapper MODELMAPPER;

	@Override
	public List<ProductDTO> getAllProducts(String category) throws ShopEasyException {
		Iterable<Product> listproducts;
		if (!category.equals("all")) {
			listproducts = productsRepository.findByProdCategory(category);
		}else {
			listproducts = productsRepository.findAll();
		}
		List<ProductDTO> listProductsDTO = new ArrayList<>();
		listproducts.forEach(products -> {
			ProductDTO productsDTO=MODELMAPPER.map(products,ProductDTO.class);
			listProductsDTO.add(productsDTO);
		});
		if(listProductsDTO.isEmpty()) {
			throw new ShopEasyException(ShopEasyConstants.NO_PRODUCTS_FOUND, HttpStatus.NOT_FOUND);
		}
		return listProductsDTO;
	}

	@Override
	public Set<ProductDTO> getAllProductsOfGivenSeller(Integer sellerId) throws ShopEasyException {
		Optional<SellerDetails> optional1= sellerDetailsRepository.findById(sellerId);
		SellerDetails sellerDetails = optional1.orElseThrow(()-> new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_SELLER_DETAILS_ID+sellerId,HttpStatus.NOT_FOUND));
		Set<Product> products = productsRepository.findBySeller(sellerDetails);
		Set<ProductDTO> productDTOS = products.stream().map(product -> MODELMAPPER.map(product,ProductDTO.class)).collect(Collectors.toSet());
		return productDTOS;
	}

	@Override
	public ProductDTO getProductById(String prodId) throws ShopEasyException {
		Optional<Product> optional = productsRepository.findById(prodId);
		Product products = optional.orElseThrow(() -> new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_PRODUCT_ID + prodId,HttpStatus.NOT_FOUND));
		ProductDTO productsDTO=MODELMAPPER.map(products,ProductDTO.class);
		return productsDTO;
	}

	@Override
	public String addProduct(ProductDTO productsDTO) throws ShopEasyException {
		if(productsDTO.getSellerId()==null){
			throw new ShopEasyException(ShopEasyConstants.USER_INFO_MISSING_IN_PRODUCT,HttpStatus.BAD_REQUEST);
		}
		Optional<SellerDetails> optional1= sellerDetailsRepository.findById(productsDTO.getSellerId());
		SellerDetails sellerDetails = optional1.orElseThrow(()-> new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_SELLER_DETAILS_ID+productsDTO.getSellerId(),HttpStatus.NOT_FOUND));
		Optional<Product> optional = productsRepository.findByProductNameAndProdCategoryAndProdSubCategoryAndSellerAndBrand(productsDTO.getProductName(),
						productsDTO.getProdCategory(), productsDTO.getProdSubCategory(),sellerDetails, productsDTO.getBrand());
		if(optional.isPresent()) {
			throw new ShopEasyException(ShopEasyConstants.RECORD_ALREADY_EXIST + optional.get().getProductId(),HttpStatus.CONFLICT);
		}
		Product product;
		product = MODELMAPPER.map(productsDTO,Product.class);
		product.setSeller(sellerDetails);
		product.setLastUpdateTime(LocalDateTime.now());
		Product saved = productsRepository.save(product);
		return ShopEasyConstants.RECORD_SUCCESSFULLY_ADDED + saved.getProductId();
	}

	@Override
	public String updateProduct(String productId, ProductDTO productDTO) throws ShopEasyException {
		Optional<Product> optional = productsRepository.findById(productId);
		Product product = optional.orElseThrow(() -> new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_PRODUCT_ID + productId, HttpStatus.NOT_FOUND));
		product.setProductName(productDTO.getProductName() != null ? productDTO.getProductName() : product.getProductName());
		product.setProdCategory(productDTO.getProdCategory() != null ? productDTO.getProdCategory() : product.getProdCategory());
		product.setProdSubCategory(productDTO.getProdSubCategory() != null ? productDTO.getProdSubCategory() : product.getProdSubCategory());
		product.setProdPrice(productDTO.getProdPrice() != 0 ? productDTO.getProdPrice() : product.getProdPrice());
		product.setDiscountPrice(productDTO.getDiscountPrice() != 0 ? productDTO.getDiscountPrice() : product.getDiscountPrice());
		product.setQuantity(productDTO.getQuantity() != null ? productDTO.getQuantity() : product.getQuantity());
		product.setProdAvailability(productDTO.getProdAvailability() != null ? productDTO.getProdAvailability() : product.getProdAvailability());
		product.setProductDesc(productDTO.getProductDesc() != null ? productDTO.getProductDesc() : product.getProductDesc());
		product.setImageUrl(productDTO.getImageUrl() != null ? productDTO.getImageUrl() : product.getImageUrl());
		product.setVideoUrl(productDTO.getVideoUrl() != null ? productDTO.getVideoUrl() : product.getVideoUrl());
		product.setBrand(productDTO.getBrand() != null ? productDTO.getBrand() : product.getBrand());
		product.setProductSize(productDTO.getProductSize() != null ? productDTO.getProductSize() : product.getProductSize());
		product.setRating(productDTO.getRating() != null ? productDTO.getRating() : product.getRating());
		product.setTotalReviews(productDTO.getTotalReviews() != null ? productDTO.getTotalReviews() : product.getTotalReviews());

		if (productDTO.getSellerId() != null) {
			Optional<SellerDetails> sellerOptional = sellerDetailsRepository.findById(productDTO.getSellerId());
			SellerDetails seller = sellerOptional.orElseThrow(() -> new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_SELLER_DETAILS_ID + productDTO.getSellerId(), HttpStatus.NOT_FOUND));
			product.setSeller(seller);
		}
		product.setLastUpdateTime(LocalDateTime.now());
		productsRepository.save(product);
		return ShopEasyConstants.RECORD_SUCCESSFULLY_UPDATED + productId;
	}
	
	@Override
	public String deleteProduct(String prodId) throws ShopEasyException {
		Optional<Product> optional = productsRepository.findById(prodId);
		optional.orElseThrow(() -> new ShopEasyException(ShopEasyConstants.NO_RECORDS_FOUND_FOR_GIVEN_PRODUCT_ID + prodId,HttpStatus.NOT_FOUND));
		productsRepository.deleteById(prodId);
		return ShopEasyConstants.RECORD_SUCCESSFULLY_DELETED + prodId;
	}

	private static ProductDTO fromEntity(Product product) {
		ProductDTO dto = new ProductDTO();
		dto.setProductId(product.getProductId());
		dto.setProductName(product.getProductName());
		dto.setProdCategory(product.getProdCategory());
		dto.setProdSubCategory(product.getProdSubCategory());
		dto.setProdPrice(product.getProdPrice());
		dto.setDiscountPrice(product.getDiscountPrice());
		dto.setQuantity(product.getQuantity());
		dto.setProdAvailability(product.getProdAvailability());
		dto.setProductDesc(product.getProductDesc());
		dto.setImageUrl(product.getImageUrl());
		dto.setVideoUrl(product.getVideoUrl());
		dto.setBrand(product.getBrand());
		dto.setProductSize(product.getProductSize());
		dto.setRating(product.getRating());
		dto.setTotalReviews(product.getTotalReviews());
		dto.setSellerId(product.getSeller() != null ? product.getSeller().getSellerId() : null);
		dto.setCreationTime(product.getCreationTime() != null ? product.getCreationTime().format(DateTimeFormatter.ISO_DATE_TIME) : null);
		dto.setLastUpdateTime(product.getLastUpdateTime() != null ? product.getLastUpdateTime().format(DateTimeFormatter.ISO_DATE_TIME) : null);
		return dto;
	}
}
