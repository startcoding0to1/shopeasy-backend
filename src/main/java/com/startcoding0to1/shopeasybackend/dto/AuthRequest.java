package com.startcoding0to1.shopeasybackend.dto;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.ALWAYS)
public class AuthRequest {

    private String userEmail;

    private String userPassword;

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

	@Override
	public int hashCode() {
		return Objects.hash(userEmail, userPassword);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthRequest other = (AuthRequest) obj;
		return Objects.equals(userEmail, other.userEmail) && Objects.equals(userPassword, other.userPassword);
	}

	@Override
	public String toString() {
		return "AuthRequest [userEmail=" + userEmail + ", userPassword=" + userPassword + "]";
	}
    
}
