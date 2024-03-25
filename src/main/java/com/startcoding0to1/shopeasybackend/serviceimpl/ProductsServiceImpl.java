package com.startcoding0to1.shopeasybackend.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.startcoding0to1.shopeasybackend.exception.ShopEasyException;
import com.startcoding0to1.shopeasybackend.constants.ShopEasyConstants;
import com.startcoding0to1.shopeasybackend.dto.ProductsDTO;
import com.startcoding0to1.shopeasybackend.entity.Products;
import com.startcoding0to1.shopeasybackend.repository.ProductsRepository;
import com.startcoding0to1.shopeasybackend.service.ProductsService;
import jakarta.transaction.Transactional;

@Service(value = "ProductsService")
@Transactional
public class ProductsServiceImpl implements ProductsService {
	@Autowired
	ProductsRepository productsRepository;

	public List<ProductsDTO> getAllProducts() throws ShopEasyException {
		Iterable<Products> listproducts = productsRepository.findAll();
		List<ProductsDTO> listProductsDTO = new ArrayList<>();

		if (listproducts == null || !listproducts.iterator().hasNext())
			throw new ShopEasyException(ShopEasyConstants.NO_PRODUCTS_FOUND);

		listproducts.forEach(products -> {
			ProductsDTO productsDTO = new ProductsDTO(products);
			listProductsDTO.add(productsDTO);
		});
		return listProductsDTO;

	}
}