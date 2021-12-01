package com.example.oop_project_47.LoginModule;

import com.example.oop_project_47.Admin.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.mail.internet.AddressException;

@Controller
public class LoginController implements WebMvcConfigurer {
    private String username;
    private String password;
    private boolean status;

    @Autowired
    private LoginRepository loginRepository;

    Admin admin = new Admin();

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ModelAndView displayLogin(ModelAndView modelAndView, LoginCredentials loginCredentials) {
        LoginCredentials existingUser = loginRepository.findByUsername(admin.getUsername());
        if(existingUser == null) {
            loginCredentials.setAdminCredentials(admin.getId(), "ADMIN", admin.getUsername(), admin.getPassword());
            loginRepository.save(loginCredentials);
        }

        modelAndView.addObject("LoginCredentials", loginCredentials);
        modelAndView.setViewName("/Authenticate");
        return modelAndView;
    }

    @RequestMapping(value = "/Dashboard", method = RequestMethod.POST)
    public ModelAndView loginUser(ModelAndView modelAndView, LoginCredentials loginCredentials) throws AddressException {
        LoginCredentials existingUser = loginRepository.findByUsername(loginCredentials.getUsername());
        //username = loginCredentials.getUsername();
        //password = loginCredentials.getPassword();
        if (existingUser != null) {
            if(loginCredentials.getUsername().equals(existingUser.getUsername())  && loginCredentials.getPassword().equals(existingUser.getPassword()))  {
                if(existingUser.getUser_role().equals("ADMIN"))  {
                    modelAndView.setViewName("redirect:/Dashboard/a");

                }
                else if(existingUser.getUser_role().equals("CAR_OWNER"))  {
                    modelAndView.setViewName("/DashboardModule2/UserDashboard/HomeUserDashboard");
                    //Enter Owner Dashboard here
                }
                else if(existingUser.getUser_role().equals("WORKER"))  {
                    //Enter Worker Dashboard here
                }
            }
            else {
                modelAndView.setViewName("/index");

            }
        }
        else {
            modelAndView.setViewName("/index");
        }
        //modelAndView.setViewName("/DashboardModule2/AdminDashboard/DashboardAdmin");
        return modelAndView;
    }

}


