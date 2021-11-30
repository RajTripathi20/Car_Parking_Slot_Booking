package com.example.oop_project_47.DashboardModule;


import com.example.oop_project_47.Admin.Admin;
import com.example.oop_project_47.LoginModule.LoginCredentials;
import com.example.oop_project_47.LoginModule.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.mail.internet.AddressException;

@Controller
public class AdminDashboardController implements WebMvcConfigurer {

    @RequestMapping(value = "/Dashboard", method = RequestMethod.GET)
    public ModelAndView displayHome(ModelAndView modelAndView, LoginCredentials loginCredentials) {

        modelAndView.addObject("LoginCredentials", loginCredentials);
        modelAndView.setViewName("/DashboardModule2/AdminDashboard/DashboardAdmin");
        return modelAndView;
    }


    @RequestMapping(value = "/Dashboard/Bookings", method = RequestMethod.GET)
    public ModelAndView displayBooking(ModelAndView modelAndView, LoginCredentials loginCredentials) {

        modelAndView.addObject("LoginCredentials", loginCredentials);
        modelAndView.setViewName("/DashboardModule2/AdminDashboard/Bookings_admin");
        return modelAndView;
    }

    @RequestMapping(value = "/Dashboard/ParkingSpace", method = RequestMethod.GET)
    public ModelAndView displayParkingSpace(ModelAndView modelAndView, LoginCredentials loginCredentials) {

        modelAndView.addObject("LoginCredentials", loginCredentials);
        modelAndView.setViewName("/DashboardModule2/AdminDashboard/ParkingSpacesAdmin");
        return modelAndView;
    }

    @RequestMapping(value = "/Dashboard/Amenities", method = RequestMethod.GET)
    public ModelAndView displayAmenities(ModelAndView modelAndView, LoginCredentials loginCredentials) {

        modelAndView.addObject("LoginCredentials", loginCredentials);
        modelAndView.setViewName("/DashboardModule2/AdminDashboard/AmenitiesAdmin");
        return modelAndView;
    }

    @RequestMapping(value = "/Dashboard/Report", method = RequestMethod.GET)
    public ModelAndView displayReport(ModelAndView modelAndView, LoginCredentials loginCredentials) {

        modelAndView.addObject("LoginCredentials", loginCredentials);
        modelAndView.setViewName("/DashboardModule2/AdminDashboard/ReportAdmin");
        return modelAndView;
    }

    @RequestMapping(value = "/Dashboard/AllUsers", method = RequestMethod.GET)
    public ModelAndView displayAllUsers(ModelAndView modelAndView, LoginCredentials loginCredentials) {

        modelAndView.addObject("LoginCredentials", loginCredentials);
        modelAndView.setViewName("/DashboardModule2/AdminDashboard/AllUsersAdmin");
        return modelAndView;
    }

    @RequestMapping(value = "/Dashboard/Settings", method = RequestMethod.GET)
    public ModelAndView displaySetting(ModelAndView modelAndView, LoginCredentials loginCredentials) {

        modelAndView.addObject("LoginCredentials", loginCredentials);
        modelAndView.setViewName("/DashboardModule2/AdminDashboard/SettingAdmin");
        return modelAndView;
    }}







