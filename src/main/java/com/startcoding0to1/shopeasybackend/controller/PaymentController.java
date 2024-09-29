package com.startcoding0to1.shopeasybackend.controller;

import com.startcoding0to1.shopeasybackend.dto.BankUserDetailsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/startcoding0to1/shopEasy")
@CrossOrigin(origins = "http://localhost:4200/")
public class PaymentController {

    @GetMapping(value = "/bankUser/{bankId}")
    public ResponseEntity<String> getBankUserDetails(@PathVariable(name = "bankId") Integer bankId){

        return null;
    }

    @PostMapping(value = "/bankUser")
    public ResponseEntity<String> addBankUserDetails(@RequestBody BankUserDetailsDTO bankUserDetailsDTO){

        return null;
    }

    @PutMapping(value = "/bankUser/{bankId}")
    public ResponseEntity<String> updateBankUserDetails(@PathVariable(name = "bankId") Integer bankId, @RequestBody BankUserDetailsDTO bankUserDetailsDTO){

        return null;
    }

    @DeleteMapping(value = "/bankUser/{bankId}")
    public ResponseEntity<String> deleteBankUserDetails(@PathVariable(name = "bankId") Integer bankId){

        return null;
    }
}
