package com.project.Jobportal.controllers;

import com.project.Jobportal.Models.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {

    @GetMapping("/")
    public ModelAndView showHome(){
        System.out.println("Logging:Controller Method=> showHome()");
        ModelAndView modelAndView =  new ModelAndView("html/home.html");
        modelAndView.addObject("test","test value");
        return modelAndView;
    }

    @GetMapping("/AboutUs")
    public ModelAndView showAboutUs(){
        System.out.println("Logging:Controller Method=> showAboutUs()");
        return new ModelAndView("html/AboutUs.html");
    }

    @GetMapping("/ContactUs")
    public ModelAndView showContactUs(){
        System.out.println("Logging:Controller Method=> showContactUs()");
        return new ModelAndView("html/ContactUs.html");
    }
//    @GetMapping("/internships")
//    public ModelAndView showInternships(){
//        System.out.println("Logging:Controller Method=> showInternships()");
//        return new ModelAndView("html/Internships.html");
//    }
}
