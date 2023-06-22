package com.project.Jobportal.controllers;

import com.project.Jobportal.Models.Job;
import com.project.Jobportal.Service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("jobs")
public class JobController {
    private final JobService jobService;
    private final int PAGE_SIZE = 10;
    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showJobs(){
        System.out.println("Logging:Controller Method=> showjobs()");
        int currentPage = 0;
        Page<Job> jobPage = jobService.getAllJobs(PageRequest.of(currentPage, PAGE_SIZE));
        ModelAndView modelAndView = new ModelAndView("html/Jobs.html");
        modelAndView.addObject("jobPage", jobPage);

        return modelAndView;
    }

    @RequestMapping(path = {"/search"})
    public ModelAndView search( @RequestParam("page") Optional<Integer> page, String keyword) {
        System.out.println("Reached Job Search Controller");
        ModelAndView modelAndView = new ModelAndView("html/Jobs.html");

        int currentPage = page.orElse(0);
        Page<Job> jobPage;
        if (keyword != null) {
             jobPage = jobService.getByKeyword(keyword, PageRequest.of(currentPage, PAGE_SIZE));
        } else {
            jobPage = jobService.getAllJobs(PageRequest.of(currentPage, PAGE_SIZE));
        }

        modelAndView.addObject("jobPage", jobPage);
        modelAndView.addObject("keyword", keyword);

        return modelAndView;
    }
}
