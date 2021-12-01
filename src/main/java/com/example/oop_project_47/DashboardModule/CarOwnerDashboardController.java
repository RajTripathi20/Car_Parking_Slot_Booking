package com.example.oop_project_47.DashboardModule;

import com.example.oop_project_47.Car_Owner.CarOwner;
import com.example.oop_project_47.LoginModule.LoginCredentials;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class CarOwnerDashboardController implements WebMvcConfigurer {

    @RequestMapping(value = "/Dashboard/u{userId}", method = RequestMethod.GET)
    public ModelAndView displayHome(ModelAndView modelAndView, CarOwner carOwner, @PathVariable String userId) {

        modelAndView.addObject("carOwner", carOwner);
        modelAndView.setViewName("/DashboardModule2/UserDashboard/HomeUserDashboard");
        return modelAndView;
    }
}
