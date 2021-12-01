package com.example.oop_project_47.Bookings;
import java.util.*;

import com.example.oop_project_47.Model.BaseEntity;
import com.example.oop_project_47.Model.NamedEntity;
import com.example.oop_project_47.Model.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "Bookings")
public class Bookings {

    @Id
    @Column(name = "BookingNumber")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "UserName")
    @NotEmpty
    private String username;

    @Column(name = "Checkin Time")
    @NotEmpty
    private String check_in;

    @Column(name = "Checkout Time")
    @NotEmpty
    private String check_out;

    @Column(name = "Parking Space")
    @NotEmpty
    private String space;

    @Column(name = "E-mail")
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

    public String getCheck_in() {
        return check_in;
    }

    public void setCheck_in(String check_in) {
        this.check_in = check_in;
    }

    public String getCheck_out() {
        return check_out;
    }

    public void setCheck_out(String check_out) {
        this.check_out = check_out;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
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

