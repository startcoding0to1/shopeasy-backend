package com.startcoding0to1.shopeasybackend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class AdminDetailsDTO{
    private Integer adminId;
    private String userId;
    private Set<AddressDTO> addressDTOS;
    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Set<AddressDTO> getAddressDTOS() {
        return addressDTOS;
    }

    public void setAddressDTOS(Set<AddressDTO> addressDTOS) {
        this.addressDTOS = addressDTOS;
    }
}
