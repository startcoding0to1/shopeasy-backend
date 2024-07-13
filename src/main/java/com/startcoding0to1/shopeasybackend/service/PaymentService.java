package com.startcoding0to1.shopeasybackend.service;

import com.startcoding0to1.shopeasybackend.dto.BankUserDetailsDTO;

public interface PaymentService {
    public BankUserDetailsDTO getBankUserDetails(Integer bankUserId);
    public String addBankUserDetails(BankUserDetailsDTO bankUserDetailsDTO);
    public String updateBankUserDetails(Integer bankUserId,BankUserDetailsDTO bankUserDetailsDTO);
    public String deleteBankUserDetails(Integer bankUserId);
}
