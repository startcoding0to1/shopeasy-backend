package com.startcoding0to1.shopeasybackend.service;

import com.startcoding0to1.shopeasybackend.dto.CommunicationDTO;
import com.startcoding0to1.shopeasybackend.dto.SuccessResponse;

public interface CommunicationService {

	public SuccessResponse sendSms(CommunicationDTO communicationDTO);

}
