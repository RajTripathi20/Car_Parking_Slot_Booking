package com.example.oop_project_47.Model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

@MappedSuperclass
public class User extends BaseEntity {

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


    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;


    }   public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;


    }   public String getEmail_ID() {
        return this.email_id;
    }

    public void setEmail_ID(String email_id) {
        this.email_id = email_id;


    }   public String getPhone_Number() {
        return this.phone_number;
    }

    public void setPhone_Number(String phone_number) {
        this.phone_number = phone_number;
    }

}
