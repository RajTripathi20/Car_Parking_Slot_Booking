package com.example.oop_project_47.system;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/forgot_pass").setViewName("/SignInModule1/ForgetPass");
        registry.addViewController("/register").setViewName("/SignInModule1/SignUppage_1");
        registry.addViewController("/dashboard").setViewName("DashboardModule2/AdminDashboard/DashboardAdmin");
        registry.addViewController("/").setViewName("/SignInModule1/LandingPage");
        registry.addViewController("/login").setViewName("/SignInModule1/Authenticate");
        registry.addViewController("/pass_change").setViewName("/SignInModule1/SuccessfulChange");
    }

}