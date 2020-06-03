package com.utcn.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "users")
public class User implements Serializable {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private BillingAddress billingAddress;
    private UserRole role;
    private String IDNumber;

    public User() {
    }

    @Id
    @Column(name = "email", unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String username) {
        this.email = username;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "phone_number", unique = true, nullable = false)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id", nullable = false)
    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    @Column(name = "id_number", nullable = false, unique = true)
    public String getIDNumber() {
        return IDNumber;
    }

    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

}
