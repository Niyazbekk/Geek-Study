package com.example.enrollmentcoreapi.service;

import com.example.enrollmentcoreapi.Repository.EnrollmentEntity;
import com.example.enrollmentcoreapi.Repository.EnrollmentRepository;
import com.example.enrollmentcoreapi.model.EnrollmentRequest;
import com.example.enrollmentcoreapi.model.EnrollmentResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnrollmentServiceImpl implements EnrollmentService{
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public EnrollmentResponse createEnroll(EnrollmentRequest enrollmentRequest) {
        EnrollmentEntity enrollmentEntity = modelMapper.map(enrollmentRequest,EnrollmentEntity.class);
        enrollmentEntity = enrollmentRepository.save(enrollmentEntity);
        return modelMapper.map(enrollmentEntity,EnrollmentResponse.class);
    }

    @Override
    public List<EnrollmentResponse> getAllEnrolls() {
        return enrollmentRepository.getEnrollmentEntityBy().stream()
                .map(enroll -> modelMapper.map(enroll,EnrollmentResponse.class))
                .collect(Collectors.toList());
    }


    @Override
    public void deleteEnrollById(Long id) {
        enrollmentRepository.deleteEnrollmentEntityById(id);
    }

    @Override
    public List<EnrollmentEntity> getEnrollmentEntitiesByUserID(Long user_id) {
        return enrollmentRepository.findByUserID(user_id);
    }
}
