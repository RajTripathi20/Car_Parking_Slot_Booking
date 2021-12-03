package com.example.oop_project_47.Bookings;
import java.time.LocalDateTime;
import java.util.*;

import com.example.oop_project_47.Model.BaseEntity;
import com.example.oop_project_47.Model.NamedEntity;
import com.example.oop_project_47.Model.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "Bookings")
public class Booking extends NamedEntity {

    @Id
    @Column(name = "BookingNumber")
    private Integer id;

    @Column(name = "Username")
    @NotEmpty
    private String username;

    @Column(name = "Checkin_DateTime")
    @NotEmpty
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime checkIn;

    @Column(name = "Checkout_DateTime")
    @NotEmpty
    @DateTimeFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime checkOut;

    @Column(name = "Parking_Space")
    @NotEmpty
    private String space;

    @Column(name = "Location")
    @NotEmpty
    private String location;

    @Column(name = "Email_ID")
    @NotEmpty
    private String email;

    @Column(name = "Status")
    @NotEmpty
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

