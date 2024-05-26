package com.startcoding0to1.shopeasybackend.entity;

import com.startcoding0to1.shopeasybackend.generator.UserIdGenerator;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;

@Entity
@Table(name = "_user")
public class User {

    @Id
    @GenericGenerator(name="user_id_seq", type=UserIdGenerator.class)
    @GeneratedValue(generator = "user_id_seq")
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "first_name")
    private String userFirstName;

    @Column(name = "last_name")
    private String userLastName;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private Set<Address> addresses;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name="USER_ROLE",
            joinColumns = {
                    @JoinColumn(name="USER_ID", nullable = false),
            },
            inverseJoinColumns = {
                    @JoinColumn(name="ROLE_ID", nullable = false)
            }
    )
    private Set<Roles> roles;

//    @JoinTable(
//            name="USER_PRODUCTS",
//            joinColumns = {
//                    @JoinColumn(name="USER_ID")
//            },
//            inverseJoinColumns = {
//                    @JoinColumn(name = "Product_ID")
//            }
//    )
//    private Set<Products> products;

    @Column(name = "phone_number")
    private Long phoneNumber;

    @Column(name = "email")
    private String userEmail;

    @Column(name = "password")
    private String userPassword;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
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
}
