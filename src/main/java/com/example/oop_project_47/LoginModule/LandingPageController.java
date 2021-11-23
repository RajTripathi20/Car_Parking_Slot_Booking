package com.example.oop_project_47.LoginModule;

import org.springframework.web.bind.annotation.RequestMapping;

public class LandingPageController extends LoginController{
    @RequestMapping
    public String next()
    {
        if(getStatus())
        {
            return "dashboard/dashboard";
        }
        return "/error";
    }
}
