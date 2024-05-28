package com.startcoding0to1.shopeasybackend.dto;

import com.startcoding0to1.shopeasybackend.entity.Role;
import com.startcoding0to1.shopeasybackend.entity.User;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

public class UserDTO {

    private String userId;
    private String userFirstName;
    private String userLastName;
    private Long phoneNumber;
    private String userEmail;
    private String userPassword;
    private Set<Role> roles;
    private LocalDateTime creationTime;
    private LocalDateTime lastUpdateTime;

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

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(LocalDateTime creationTime) {
        this.creationTime = creationTime;
    }

    public LocalDateTime getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(LocalDateTime lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getUserId(), user.getUserId()) && Objects.equals(getUserFirstName(), user.getUserFirstName()) && Objects.equals(getUserLastName(), user.getUserLastName()) && Objects.equals(getPhoneNumber(), user.getPhoneNumber()) && Objects.equals(getUserEmail(), user.getUserEmail()) && Objects.equals(getUserPassword(), user.getUserPassword()) && Objects.equals(getRoles(), user.getRoles()) && Objects.equals(getCreationTime(), user.getCreationTime()) && Objects.equals(getLastUpdateTime(), user.getLastUpdateTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUserFirstName(), getUserLastName(), getPhoneNumber(), getUserEmail(), getUserPassword(), getRoles(), getCreationTime(), getLastUpdateTime());
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", roles=" + roles +
                ", creationTime=" + creationTime +
                ", lastUpdateTime=" + lastUpdateTime +
                '}';
    }
}