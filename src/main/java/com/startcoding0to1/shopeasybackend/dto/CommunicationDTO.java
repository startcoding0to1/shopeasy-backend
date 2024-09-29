package com.startcoding0to1.shopeasybackend.dto;

import java.util.Objects;

public class CommunicationDTO {
	private String userName;
	private String phoneNo;
	private String message;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public int hashCode() {
		return Objects.hash(message, phoneNo, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommunicationDTO other = (CommunicationDTO) obj;
		return Objects.equals(message, other.message) && Objects.equals(phoneNo, other.phoneNo)
				&& Objects.equals(userName, other.userName);
	}
	@Override
	public String toString() {
		return "CommunicationDTO [userName=" + userName + ", phoneNo=" + phoneNo + ", message=" + message + "]";
	}
}
