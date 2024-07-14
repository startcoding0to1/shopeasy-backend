package com.startcoding0to1.shopeasybackend.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.startcoding0to1.shopeasybackend.entity.Role;

import java.util.Objects;
import java.util.Set;
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserDTO {
    private String userId;
    private String userFirstName;
    private String userLastName;
    private Long phoneNumber;
    private String userEmail;
    private String userPassword;
    private Set<Role> roles;
    private String creationTime;
    private String lastUpdateTime;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(String lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

	@Override
	public int hashCode() {
		return Objects.hash(creationTime, lastUpdateTime, phoneNumber, roles, userEmail, userFirstName, userId,
				userLastName, userPassword);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		return Objects.equals(creationTime, other.creationTime) && Objects.equals(lastUpdateTime, other.lastUpdateTime)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(roles, other.roles)
				&& Objects.equals(userEmail, other.userEmail) && Objects.equals(userFirstName, other.userFirstName)
				&& Objects.equals(userId, other.userId) && Objects.equals(userLastName, other.userLastName)
				&& Objects.equals(userPassword, other.userPassword);
	}

	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", phoneNumber=" + phoneNumber + ", userEmail=" + userEmail + ", userPassword=" + userPassword
				+ ", roles=" + roles + ", creationTime=" + creationTime + ", lastUpdateTime=" + lastUpdateTime + "]";
	}

}