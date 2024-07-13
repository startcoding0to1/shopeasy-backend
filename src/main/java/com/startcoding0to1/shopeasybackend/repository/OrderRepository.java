package com.startcoding0to1.shopeasybackend.repository;

import com.startcoding0to1.shopeasybackend.entity.CustomerOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<CustomerOrder,Integer> {
}
