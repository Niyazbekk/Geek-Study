package com.example.studyofficeapi.feign;

import com.example.studyofficeapi.model.CourseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("courses-core-api")
public interface CourseFeign {
    @GetMapping("/course/check")
    String checkCourse();

    @GetMapping("/course/all")
    List<CourseResponse> getAllCourses();

    @GetMapping("/course/{Id}")
    CourseResponse getCourseById(@PathVariable Long Id);
}
