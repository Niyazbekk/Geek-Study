package com.example.coursescoreapi.service;

import com.example.coursescoreapi.Repository.CourseEntity;
import com.example.coursescoreapi.model.CourseRequest;
import com.example.coursescoreapi.model.CourseResponse;

import java.util.List;

public interface CourseService {
    CourseResponse createCourse(CourseRequest coursesRequest);

    List<CourseResponse> getAllCourses();

    CourseResponse getCourseById(Long id);

    CourseResponse updateCourseById(CourseRequest coursesRequest);

    void deleteCourseById(Long id);

    List<CourseEntity> getCoursesByUserId(int userID);

}
