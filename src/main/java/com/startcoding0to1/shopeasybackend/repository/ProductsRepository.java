package com.startcoding0to1.shopeasybackend.repository;

import org.springframework.data.repository.CrudRepository;
import com.startcoding0to1.shopeasybackend.entity.Products;

public interface ProductsRepository extends CrudRepository<Products, String> {

}