package com.project.Jobportal.Service;

import com.project.Jobportal.Models.Internship;
import com.project.Jobportal.Models.Job;
import com.project.Jobportal.Repository.InternshipRepository;
import com.project.Jobportal.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternshipService {
    private final InternshipRepository repository;

    @Autowired
    public InternshipService(InternshipRepository repository) {
        this.repository = repository;
    }


    public Page<Internship> getAllInternships(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Page<Internship> getByKeyword(String keyword, Pageable pageable){
        return repository.findByKeyword(keyword, pageable);
    }

}