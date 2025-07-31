package com.example.jobtracker.service;

import com.example.jobtracker.model.JobApplication;
import com.example.jobtracker.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    private static JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

//    @Autowired
//    private static JobRepository jobRepository;

    // ฟังก์ชันในการบันทึกข้อมูลการสมัครงาน
    public JobApplication saveJobApplication(JobApplication jobApplication) {
        jobApplication.setStatus("กำลังพิจารณา");  // กำหนดสถานะเริ่มต้น
        return jobRepository.save(jobApplication);
    }

    // ฟังก์ชันในการเปลี่ยนสถานะ
    public JobApplication updateStatus(Long id, String status) {
        JobApplication jobApplication = jobRepository.findById(id).orElseThrow();
        jobApplication.setStatus(status);
        return jobRepository.save(jobApplication);
    }

    // ฟังก์ชันในการดึงข้อมูลผู้สมัครจาก email
    public static JobApplication getJobApplicationByEmail(String email) {
        return jobRepository.findByEmail(email);
    }

//    public String updateStatus(@RequestParam Long id, @RequestParam String status) {
//        JobService.updateStatus(id, status);
//        return "Status updated successfully";
//    }
}


