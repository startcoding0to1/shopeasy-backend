package com.startcoding0to1.shopeasybackend.repository;

import com.startcoding0to1.shopeasybackend.entity.BankUserDetails;
import org.springframework.data.repository.CrudRepository;

public interface PaymentRepository extends CrudRepository<BankUserDetails,Integer> {
}
