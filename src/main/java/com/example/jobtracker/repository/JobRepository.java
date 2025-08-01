package com.example.jobtracker.repository;

import com.example.jobtracker.model.JobApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobApplication, Long> {
    // คุณสามารถค้นหาผู้สมัครจาก status หรือ email ได้
    JobApplication findByEmail(String email);

//    @Autowired
//    JobRepository jobRepository = null;
}


