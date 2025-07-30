package com.example.jobtracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Service
public class JobService {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    // ฟังก์ชันในการบันทึกข้อมูลการสมัครงาน
    public JobApplication saveJobApplication(JobApplication jobApplication) {
        jobApplication.setStatus("กำลังพิจารณา");  // กำหนดสถานะเริ่มต้น
        return jobApplicationRepository.save(jobApplication);
    }

    // ฟังก์ชันในการเปลี่ยนสถานะ
    public JobApplication updateStatus(Long id, String status) {
        JobApplication jobApplication = jobApplicationRepository.findById(id).orElseThrow();
        jobApplication.setStatus(status);
        return jobApplicationRepository.save(jobApplication);
    }

    // ฟังก์ชันในการดึงข้อมูลผู้สมัครจาก email
    public JobApplication getJobApplicationByEmail(String email) {
        return jobApplicationRepository.findByEmail(email);
    }
}


