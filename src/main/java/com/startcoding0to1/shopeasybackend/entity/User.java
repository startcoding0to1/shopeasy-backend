package com.startcoding0to1.shopeasybackend.entity;

import com.startcoding0to1.shopeasybackend.generator.UserIdGenerator;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public  class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GenericGenerator(name="user_id_seq", type=UserIdGenerator.class)
    @GeneratedValue(generator = "user_id_seq")
    @Column(name = "user_id",length = 200)
    private String userId;

    @Column(name = "first_name")
    private String userFirstName;

    @Column(name = "last_name")
    private String userLastName;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "email")
    private String userEmail;

    @Column(name = "password")
    private String userPassword;

    @Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id")
    )
    @Column(name = "role")
    private Set<Role> roles;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    @Column(name = "last_update_time")
    private LocalDateTime lastUpdateTime;

    @OneToOne(mappedBy = "user" ,cascade = CascadeType.REMOVE, orphanRemoval = true)
    private AdminDetails adminDetails;
    @OneToOne(mappedBy = "user" ,cascade = CascadeType.REMOVE, orphanRemoval = true)
    private CustomerDetails customerDetails;

    @OneToOne(mappedBy = "user" ,cascade = CascadeType.REMOVE, orphanRemoval = true)
    private SellerDetails sellerDetails;

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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
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

    public AdminDetails getAdminDetails() {
        return adminDetails;
    }

    public void setAdminDetails(AdminDetails adminDetails) {
        this.adminDetails = adminDetails;
    }

    public CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public SellerDetails getSellerDetails() {
        return sellerDetails;
    }

    public void setSellerDetails(SellerDetails sellerDetails) {
        this.sellerDetails = sellerDetails;
    }

	@Override
	public int hashCode() {
		return Objects.hash(adminDetails, creationTime, customerDetails, lastUpdateTime, phoneNumber, roles,
				sellerDetails, userEmail, userFirstName, userId, userLastName, userPassword);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(adminDetails, other.adminDetails) && Objects.equals(creationTime, other.creationTime)
				&& Objects.equals(customerDetails, other.customerDetails)
				&& Objects.equals(lastUpdateTime, other.lastUpdateTime)
				&& Objects.equals(phoneNumber, other.phoneNumber) && Objects.equals(roles, other.roles)
				&& Objects.equals(sellerDetails, other.sellerDetails) && Objects.equals(userEmail, other.userEmail)
				&& Objects.equals(userFirstName, other.userFirstName) && Objects.equals(userId, other.userId)
				&& Objects.equals(userLastName, other.userLastName) && Objects.equals(userPassword, other.userPassword);
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", phoneNumber=" + phoneNumber + ", userEmail=" + userEmail + ", userPassword=" + userPassword
				+ ", roles=" + roles + ", creationTime=" + creationTime + ", lastUpdateTime=" + lastUpdateTime
				+ ", adminDetails=" + adminDetails + ", customerDetails=" + customerDetails + ", sellerDetails="
				+ sellerDetails + "]";
	}
    
}
