package com.example.enrollmentcoreapi.controller;

import com.example.enrollmentcoreapi.Repository.EnrollmentEntity;
import com.example.enrollmentcoreapi.model.EnrollmentRequest;
import com.example.enrollmentcoreapi.model.EnrollmentResponse;
import com.example.enrollmentcoreapi.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/enroll")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    Environment env;

    @GetMapping("/check")
    public String check(){
        return "enrollment-core-api is working at " + env.getProperty("local.server.port") + " port";
    }

    @PostMapping
    public EnrollmentResponse createCourse(@Valid @RequestBody EnrollmentRequest enrollmentRequest) {

        return enrollmentService.createEnroll(enrollmentRequest);
    }

    @GetMapping("/all")
    public List<EnrollmentResponse> getAllCourses(){
        return enrollmentService.getAllEnrolls();
    }


    @GetMapping("/{user_id}")
    public List<EnrollmentEntity> getCoursesById(@PathVariable Long user_id) {
        return enrollmentService.getEnrollmentEntitiesByUserID(user_id);
    }


    @DeleteMapping("/{id}")
    public void deleteCourseById(@PathVariable Long id) {
        enrollmentService.deleteEnrollById(id);
    }
}
