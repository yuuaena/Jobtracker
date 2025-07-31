package com.example.jobtracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or another strategy you prefer
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String experience;
//    private MultipartFile resume;
    private String status;

    public void setStatus(String กำลังพิจารณา) {
    }
}
