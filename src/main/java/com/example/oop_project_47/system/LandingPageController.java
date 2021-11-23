package com.example.oop_project_47.system;

import com.example.oop_project_47.Admin.AdminLoginController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LandingPageController extends AdminLoginController {
    @GetMapping("/")
    public String LandingPage()  { return "index";}

}
