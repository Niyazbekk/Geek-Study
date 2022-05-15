package com.example.enrollmentcoreapi.service;

import com.example.enrollmentcoreapi.Repository.EnrollmentEntity;
import com.example.enrollmentcoreapi.model.EnrollmentRequest;
import com.example.enrollmentcoreapi.model.EnrollmentResponse;

import java.util.List;
import java.util.Optional;

public interface EnrollmentService {
    EnrollmentResponse createEnroll(EnrollmentRequest enrollmentRequest);

    List<EnrollmentResponse> getAllEnrolls();

    //EnrollmentResponse getEnrollById(Long user_id);

    void deleteEnrollById(Long id);

    List<EnrollmentEntity> getEnrollmentEntitiesByUserID(Long user_id);
}
