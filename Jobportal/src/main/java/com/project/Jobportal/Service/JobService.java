package com.project.Jobportal.Service;

import com.project.Jobportal.Models.Job;
import com.project.Jobportal.Repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    private final JobRepository repository;

    @Autowired
    public JobService(JobRepository repository) {
        this.repository = repository;
    }


    public Page<Job> getAllJobs(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Page<Job> getByKeyword(String keyword, Pageable pageable){
        return repository.findByKeyword(keyword, pageable);
    }

}