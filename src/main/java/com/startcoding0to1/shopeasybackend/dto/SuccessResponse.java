package com.startcoding0to1.shopeasybackend.dto;

public class SuccessResponse {
	
	private String id;
	private String message;
	
	public SuccessResponse() {
		
	}
	
	public SuccessResponse(String id, String message) {
		this.id = id;
		this.message = message;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
