package com.example.oop_project_47.Car_Owner;
import java.util.*;

import com.example.oop_project_47.Model.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "Car_Owners")
public class CarOwner extends User implements UserDetails {

    @Column(name = "ID")
    private Integer id;

    @Column(name = "First_Name")
    @NotEmpty
    private String firstName;

    @Column(name = "Last_Name")
    @NotEmpty
    private String lastName;

    @Column(name = "Username")
    @NotEmpty
    private String username;

    @Column(name = "Password")
    @NotEmpty
    private String password;

    @Column(name = "Email_ID")
    @NotEmpty
    private String email_id;

    @Column(name = "Phone_Number")
    @NotEmpty
    private String phone_number;

    @Column(name = "Car_Type")
    @NotEmpty
    private String carType;

    @Column(name = "Address")
    @NotEmpty
    private String address;

    @Column(name = "Car_Registration_Number")
    @NotEmpty
    private String carRegistrationNumber;


    public String getCarType() {
        return this.carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;


    }

    public String getCarRegistrationNumber() {
        return this.carRegistrationNumber;
    }

    public void setCarRegistrationNumber(String carRegistrationNumber) {
        this.carRegistrationNumber = carRegistrationNumber;


    }
    @Enumerated(EnumType.STRING)
    @Column(name = "auth_provider")
    private AuthenticationProvider authProvider;

    public CarOwner() {
    }
    public  CarOwner(User user)
    {
        this.username=user.getUsername();
        this.email_id=user.getEmail_id();
        this.password=user.getPassword();
        this.id=user.getId();
        this.firstName=user.getFirstName();
        this.lastName=user.getLastName();
        this.phone_number=user.getPhone_number();

    }
    public void fillCarOwner()
    {
        this.username=super.getUsername();
        System.out.println(super.getUsername());
        this.email_id=super.getEmail_id();
        this.password=super.getPassword();
        this.firstName=super.getFirstName();
        this.lastName=super.getLastName();
        this.phone_number=super.getPhone_number();

    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
            return true;
    }

    public void setAuthProvider(AuthenticationProvider authProvider) {
        this.authProvider = authProvider;
    } }

