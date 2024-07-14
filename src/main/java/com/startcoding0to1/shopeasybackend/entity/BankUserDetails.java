package com.startcoding0to1.shopeasybackend.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "bank_User_details")
public class BankUserDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="bank_user_id_gen")
    @SequenceGenerator(name = "bank_user_id_gen",sequenceName = "bank_user_id_sequence",allocationSize = 1)
    @Column(name = "bank_user_id")
    private Integer bankUserId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "email_id")
    private String emailId;

    @Column(name="account_number")
    private String account_number;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name="ifsc_code")
    private String ifScCode;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "creation_time")
    private LocalDateTime creationTime;

    @Column(name = "last_update_time")
    private LocalDateTime lastUpdateTime;

    public Integer getBankUserId() {
        return bankUserId;
    }

    public void setBankUserId(Integer bankUserId) {
        this.bankUserId = bankUserId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIfScCode() {
        return ifScCode;
    }

    public void setIfScCode(String ifScCode) {
        this.ifScCode = ifScCode;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
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
	public int hashCode() {
		return Objects.hash(account_number, balance, bankName, bankUserId, creationTime, emailId, firstName, ifScCode,
				lastName, lastUpdateTime, phoneNumber);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankUserDetails other = (BankUserDetails) obj;
		return Objects.equals(account_number, other.account_number) && Objects.equals(balance, other.balance)
				&& Objects.equals(bankName, other.bankName) && Objects.equals(bankUserId, other.bankUserId)
				&& Objects.equals(creationTime, other.creationTime) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(ifScCode, other.ifScCode)
				&& Objects.equals(lastName, other.lastName) && Objects.equals(lastUpdateTime, other.lastUpdateTime)
				&& Objects.equals(phoneNumber, other.phoneNumber);
	}

	@Override
	public String toString() {
		return "BankUserDetails [bankUserId=" + bankUserId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phoneNumber=" + phoneNumber + ", emailId=" + emailId + ", account_number=" + account_number
				+ ", bankName=" + bankName + ", ifScCode=" + ifScCode + ", balance=" + balance + ", creationTime="
				+ creationTime + ", lastUpdateTime=" + lastUpdateTime + "]";
	}
    
}
