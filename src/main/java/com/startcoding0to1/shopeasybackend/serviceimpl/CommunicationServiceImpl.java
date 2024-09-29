package com.startcoding0to1.shopeasybackend.serviceimpl;

import com.startcoding0to1.shopeasybackend.dto.CommunicationDTO;
import com.startcoding0to1.shopeasybackend.dto.SuccessResponse;
import com.startcoding0to1.shopeasybackend.service.CommunicationService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CommunicationServiceImpl implements CommunicationService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.phone.number}")
    private String fromPhoneNumber;

    // Constructor for initializing Twilio SDK
    public CommunicationServiceImpl(@Value("${twilio.account.sid}") String accountSid,
                                     @Value("${twilio.auth.token}") String authToken) {
        this.accountSid = accountSid;
        this.authToken = authToken;
        Twilio.init(this.accountSid, this.authToken);
    }

    @Override
    public SuccessResponse sendSms(CommunicationDTO communicationDTO) {
    	String otp = this.getOtp();
    	String messageBody="";
    	if(communicationDTO.getMessage() != null && communicationDTO.getMessage().toLowerCase().contains("otp")) {
    		messageBody = """
    				Dear %s,
    				Login OTP is %s
    				Use this OTP to login startcoding0to1 app.
    				""";
    		messageBody = String.format(messageBody,communicationDTO.getUserName(),otp);
    	}
        Message message = Message.creator(
                new PhoneNumber(communicationDTO.getPhoneNo()),  // To phone number
                new PhoneNumber(fromPhoneNumber), // From Twilio phone number
                messageBody                        // SMS body
        ).create();
        System.out.println("SMS sent successfully with SID: " + message.getSid());
        return new SuccessResponse(otp,"SMS sent successfully to Phone No: "+communicationDTO.getPhoneNo());
    }
    
    private String getOtp() {
    	Integer otp = ThreadLocalRandom.current().nextInt(1000,10000);
    	return otp.toString();
    }
    
    
}
