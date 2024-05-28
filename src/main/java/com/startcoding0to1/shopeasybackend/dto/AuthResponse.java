package com.startcoding0to1.shopeasybackend.dto;
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
}
