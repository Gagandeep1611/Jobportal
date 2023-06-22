package com.project.Jobportal.controllers;

import com.project.Jobportal.Models.Internship;

import com.project.Jobportal.Models.Job;
import com.project.Jobportal.Service.InternshipService;
import com.project.Jobportal.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("internships")
public class InternshipController {
    private final InternshipService internshipService;
    private final int PAGE_SIZE = 10;
    @Autowired
    public InternshipController(InternshipService internshipService) {
        this.internshipService = internshipService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showInternships(){
        System.out.println("Logging:Controller Method=> showInternships()");
        int currentPage = 0;
        Page<Internship> internshipPage = internshipService.getAllInternships(PageRequest.of(currentPage, PAGE_SIZE));
        ModelAndView modelAndView = new ModelAndView("html/Internships.html");
        modelAndView.addObject("internshipPage", internshipPage);

        return modelAndView;
    }

    @RequestMapping(path = {"/search"})
    public ModelAndView search(@RequestParam("page") Optional<Integer> page, String keyword) {
        System.out.println("Reached Internship Search Controller");
        ModelAndView modelAndView = new ModelAndView("html/Internships.html");

        int currentPage = page.orElse(0);
        Page<Internship> internshipPage;
        if (keyword != null) {
            internshipPage = internshipService.getByKeyword(keyword, PageRequest.of(currentPage, PAGE_SIZE));
        } else {
            internshipPage = internshipService.getAllInternships(PageRequest.of(currentPage, PAGE_SIZE));
        }

        modelAndView.addObject("internshipPage", internshipPage);
        modelAndView.addObject("keyword", keyword);

        return modelAndView;
    }
}
