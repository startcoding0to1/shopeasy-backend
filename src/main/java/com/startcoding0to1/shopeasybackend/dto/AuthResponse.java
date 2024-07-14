package com.startcoding0to1.shopeasybackend.dto;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthResponse {
    private String message;
    private UserDTO userDTO;

    @JsonProperty("access_token")
    private String jwtToken;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

	@Override
	public int hashCode() {
		return Objects.hash(jwtToken, message, userDTO);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthResponse other = (AuthResponse) obj;
		return Objects.equals(jwtToken, other.jwtToken) && Objects.equals(message, other.message)
				&& Objects.equals(userDTO, other.userDTO);
	}

	@Override
	public String toString() {
		return "AuthResponse [message=" + message + ", userDTO=" + userDTO + ", jwtToken=" + jwtToken + "]";
	}
    
}
