package com.startcoding0to1.shopeasybackend.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.startcoding0to1.shopeasybackend.dto.CommunicationDTO;
import com.startcoding0to1.shopeasybackend.dto.SuccessResponse;
import com.startcoding0to1.shopeasybackend.service.CommunicationService;

@RestController
@RequestMapping("startcoding0to1/shopEasy")
@Validated
@CrossOrigin(origins = "http://localhost:4200/")
public class CommunicationController {
	@Autowired
    private CommunicationService communicationService;

    @PostMapping(value = "/sms",consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SuccessResponse> sendSms(@Valid @RequestBody CommunicationDTO communicationDTO) {
    	SuccessResponse message = communicationService.sendSms(communicationDTO);
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
}
