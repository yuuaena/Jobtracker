package com.example.jobtracker.controller;

import ch.qos.logback.core.model.Model;
import com.example.jobtracker.model.JobApplication;
import com.example.jobtracker.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/job")
public class JobControler {
    @Autowired
    private JobService jobApplicationService;

    @GetMapping("/status")
    public String checkStatusForm() {
        return "checkStatusForm";
    }

    @PostMapping("/status")
    public String checkStatus(@RequestParam String email, Model model) {
        JobApplication jobApplication = JobService.getJobApplicationByEmail(email);
        if (jobApplication != null) {
            model.addText("jobApplication");
            return "statusResult";
        } else {
            model.addText("message");
            return "checkStatusForm";
        }
    }


}
