package com.example.oop_project_47.LoginModule;

import com.example.oop_project_47.Admin.Admin;
import com.example.oop_project_47.Admin.AdminLoginController;
import com.example.oop_project_47.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.mail.internet.AddressException;
import javax.validation.Valid;
@Controller
public class LoginController implements WebMvcConfigurer {
    private String username;
    private String password;
    private boolean status;

    @Autowired
    private LoginRepository loginRepository;

    Admin admin = new Admin();
    int i = 0;
       //     if(i==0) {
       // oginCredentials.setAdminCredentials(admin.getId(), "ADMIN", admin.getUsername(), admin.getPassword());
        //loginRepository.save(loginCredentials);
        //i = 1;
    //}

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView displayLogin(ModelAndView modelAndView, LoginCredentials loginCredentials) {

        modelAndView.addObject("LoginCredentials", loginCredentials);
        modelAndView.setViewName("/Authenticate");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginUser(ModelAndView modelAndView, LoginCredentials loginCredentials) throws AddressException {
        LoginCredentials existingUser = loginRepository.findByUsername(loginCredentials.getUsername());
        //username = loginCredentials.getUsername();
        //password = loginCredentials.getPassword();
     /*   if (existingUser != null) {
            if(loginCredentials.getUsername() == existingUser.getUsername()  && loginCredentials.getPassword() == existingUser.getPassword())  {
                if(existingUser.getUser_role()=="ADMIN")  {
                    modelAndView.setViewName("/DashboardModule2/AdminDashboard/DashboardAdmin");

                }
                else if(existingUser.getUser_role()=="CAR_OWNER")  {
                    modelAndView.setViewName("/DashboardModule2/AdminDashboard/AllUsersAdmin");
                    //Enter Owner Dashboard here
                }
                else if(existingUser.getUser_role()=="WORKER")  {
                    //Enter Worker Dashboard here
                }
            }
            else {
                modelAndView.addObject("message", "Invalid Username or Password");
                modelAndView.setViewName("/LandingPage");

            }
        }
        else {
            modelAndView.addObject("message", "Invalid Username or Password");
            modelAndView.setViewName("/LandingPage");
        }*/
        modelAndView.setViewName("/DashboardModule2/AdminDashboard/DashboardAdmin");
        return modelAndView;
    }

}


