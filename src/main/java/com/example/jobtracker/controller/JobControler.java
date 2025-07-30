package com.example.jobtracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/apply")
public class JobControler {
    @Autowired
    private JobApplicationService jobApplicationService;

    @GetMapping("/status")
    public String checkStatusForm() {
        return "checkStatusForm";
    }

    @PostMapping("/status")
    public String checkStatus(@RequestParam String email, Model model) {
        JobApplication jobApplication = jobApplicationService.getJobApplicationByEmail(email);
        if (jobApplication != null) {
            model.addAttribute("jobApplication", jobApplication);
            return "statusResult";
        } else {
            model.addAttribute("message", "ไม่พบการสมัครงานสำหรับอีเมลนี้");
            return "checkStatusForm";
        }
    }
}
