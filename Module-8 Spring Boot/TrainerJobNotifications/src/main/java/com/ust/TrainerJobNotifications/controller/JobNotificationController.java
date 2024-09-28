package com.ust.TrainerJobNotifications.controller;

import com.ust.TrainerJobNotifications.model.Jobinfo;
import com.ust.TrainerJobNotifications.service.JobNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/ust")
public class JobNotificationController {

    @Autowired
    private JobNotificationService service;

    @PostMapping("/addnewjob")
    public Jobinfo addnewjob(@RequestBody Jobinfo newjob){
        return service.addnewjob(newjob);
    }

    @GetMapping("/jobs")
    public List<Jobinfo> getAllJobs(){
        return service.getAllJobs();
    }

    @GetMapping("/jobs/{JobId}")
    public Jobinfo getjobbyid(@PathVariable int JobId){
        return service.getjobbyid(JobId);
    }
}