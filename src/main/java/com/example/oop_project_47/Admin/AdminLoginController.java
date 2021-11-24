package com.example.oop_project_47.Admin;
/*
import com.example.oop_project_47.Admin.Admin;
import com.example.oop_project_47.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
@Controller
public class AdminLoginController implements WebMvcConfigurer {
    private String username;
    private String password;
    private boolean status;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) { this.password = password; }

    public void setUsername(String username) { this.username = username; }

    public boolean getStatus() {

        User user = new Admin();
        status = (getUsername().equals(user.getUsername()) && getPassword().equals(user.getPassword()));
        return status;
    }
    @PostMapping("/")
    //public String checkCredentials(@Valid Admin admin, BindingResult bindingResult)
    public String checkCredentials() {
        if(getStatus())
        {
            return "DashboardModule2/AdminDashboard/DashboardAdmin";
        }
        return "/SignInModule1/ForgetPass";
    }
} */
