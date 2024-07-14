package com.startcoding0to1.shopeasybackend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;
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

	@Override
	public int hashCode() {
		return Objects.hash(companyAddressesDTOs, companyName, sellerId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SellerDetailsDTO other = (SellerDetailsDTO) obj;
		return Objects.equals(companyAddressesDTOs, other.companyAddressesDTOs)
				&& Objects.equals(companyName, other.companyName) && Objects.equals(sellerId, other.sellerId)
				&& Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "SellerDetailsDTO [sellerId=" + sellerId + ", userId=" + userId + ", companyName=" + companyName
				+ ", companyAddressesDTOs=" + companyAddressesDTOs + "]";
	}
    
}
