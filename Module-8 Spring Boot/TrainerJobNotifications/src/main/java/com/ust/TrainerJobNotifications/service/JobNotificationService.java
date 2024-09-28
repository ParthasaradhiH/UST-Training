package com.ust.TrainerJobNotifications.service;


import com.ust.TrainerJobNotifications.model.Jobinfo;
import com.ust.TrainerJobNotifications.repo.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobNotificationService {
    @Autowired
    private JobRepository repo;

    public Jobinfo addnewjob(Jobinfo newjob){
        return repo.save(newjob);
    }
    public List<Jobinfo>getAllJobs(){
        return repo.findAll();
    }

    public Jobinfo getjobbyid(int jobId) {
        return repo.findById(jobId).orElse(null);
    }
}