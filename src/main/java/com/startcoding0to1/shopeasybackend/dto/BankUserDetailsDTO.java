package com.startcoding0to1.shopeasybackend.dto;

public class BankUserDetailsDTO {

    private Integer bankUserId;
    private String firstName;
    private String lastName;
    private Long phoneNumber;
    private String emailId;
    private String account_number;
    private String bankName;
    private String ifScCode;
    private Double balance;
    private String creationTime;
    private String lastUpdateTime;

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
}
