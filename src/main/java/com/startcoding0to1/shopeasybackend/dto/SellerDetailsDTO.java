package com.startcoding0to1.shopeasybackend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Set;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class SellerDetailsDTO{
    private Integer sellerId;
    private String userId;
    private String companyName;
    private Set<AddressDTO> companyAddressesDTOs;
    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Set<AddressDTO> getCompanyAddressesDTOs() {
        return companyAddressesDTOs;
    }

    public void setCompanyAddressesDTOs(Set<AddressDTO> companyAddressesDTOs) {
        this.companyAddressesDTOs = companyAddressesDTOs;
    }
}
