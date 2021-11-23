package com.example.oop_project_47.Admin;

import com.example.oop_project_47.Model.User;

import javax.persistence.Entity;

@Entity
public class Admin extends User {

    @Override
    public Integer getId()  {return 47;}

    @Override
    public String getFirstName()  {return "Admin";}

    @Override
    public String getLastName()  {return " ";}

    @Override
    public String getUsername()  {return "admin";}

    @Override
    public String getPassword()  {return "admin";}

    @Override
    public String getEmail_ID()  {return "tripathiraj01@gmail.com";}

    @Override
    public String getPhone_Number()  {return "+18507897596";}




}
