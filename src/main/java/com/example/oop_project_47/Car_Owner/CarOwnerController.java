package com.example.oop_project_47.Car_Owner;

import com.example.oop_project_47.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
//import javax.mail.internet.AddressException;

@Controller
public class CarOwnerController {

    @Autowired
    private CarOwnerDetailsService carOwnerDetailsManager;

    @Autowired
    private CarOwnerRepository carOwnerRepository;

    private PasswordEncoder passwordEncoder;

    @Value("${host.name}")
    private String localhost;

    @Qualifier("confirmationTokenRepository")
    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView displayRegistration(ModelAndView modelAndView, CarOwner carOwner) {
        modelAndView.addObject("CarOwner", carOwner);
        modelAndView.setViewName("/SignUppage_1");
        return modelAndView;
    }



   /* @PostMapping(
            value = "/register",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces = {
            MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }
    )*/
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView registerUser(ModelAndView modelAndView, CarOwner carOwner) {
        carOwner.fillCarOwner();
        carOwnerRepository.save(carOwner);
        ConfirmationToken confirmationToken = new ConfirmationToken(carOwner);

        confirmationTokenRepository.save(confirmationToken);
        modelAndView.setViewName("/SuccessfulRegistration");
        return modelAndView;
    }
       /* CarOwner carOwner = new CarOwner();
        carOwner.setUsername(body.get("username"));
        carOwner.setPassword(passwordEncoder.encode(body.get("password")));
        carOwner.setUsername(body.get("firstName"));
        carOwner.setUsername(body.get("lastName"));
        carOwner.setUsername(body.get("emailId"));
        carOwner.setUsername(body.get("mobileNo"));
        carOwnerDetailsManager.createCarOwner(carOwner);
    }
    private String getErrorMessage(HttpServletRequest request, String key) {
        Exception exception = (Exception) request.getSession().getAttribute(key);
        String error = "";
        if (exception instanceof BadCredentialsException) {
            error = "Invalid username and password!";
        } else if (exception instanceof LockedException) {
            error = exception.getMessage();
        } else {
            error = "Invalid username and password!";
        }
        return error;
    }*/
}