package com.example.studyofficeapi.feign;

import com.example.studyofficeapi.model.CourseResponse;
import com.example.studyofficeapi.model.EnrollResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("enrollment-core-api")
public interface EnrollFeign {
    @GetMapping("/enroll/check")
    String checkEnroll();

    @GetMapping("/enroll/all")
    List<EnrollResponse> getAllEnrollments();

    @GetMapping("/enroll/{userId}")
    List<EnrollResponse> getEnrollsByUserId(@PathVariable String userId);

    @GetMapping("/enroll/api/{userId}")
    List<CourseResponse> getCoursesByEnrolls(@PathVariable String userId);

}
