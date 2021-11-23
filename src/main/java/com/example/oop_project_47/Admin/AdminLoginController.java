package com.example.oop_project_47.Admin;

import com.example.oop_project_47.Admin.Admin;
import com.example.oop_project_47.Model.User;
import org.springframework.web.bind.annotation.RequestMapping;

public class AdminLoginController {
    private String username;
    private String password;
    private boolean status;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    /*
    public void setPassword(String password) { this.password = password; }

    public void setUsername(String username) { this.username = username; }*/

    public boolean getStatus() {

        User user = new Admin();
        status = (getUsername().equals(user.getUsername()) && getPassword().equals(user.getPassword()));
        return status;
    }
    public String next()
    {
        if(getStatus())
        {
            return "DashboardModule2/AdminDashboard/DashboardAdmin";
        }
        return "/error";
    }
}
