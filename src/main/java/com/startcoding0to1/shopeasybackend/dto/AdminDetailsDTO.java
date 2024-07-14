package com.startcoding0to1.shopeasybackend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Objects;
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

	@Override
	public int hashCode() {
		return Objects.hash(addressDTOS, adminId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminDetailsDTO other = (AdminDetailsDTO) obj;
		return Objects.equals(addressDTOS, other.addressDTOS) && Objects.equals(adminId, other.adminId)
				&& Objects.equals(userId, other.userId);
	}

	@Override
	public String toString() {
		return "AdminDetailsDTO [adminId=" + adminId + ", userId=" + userId + ", addressDTOS=" + addressDTOS + "]";
	}
}
