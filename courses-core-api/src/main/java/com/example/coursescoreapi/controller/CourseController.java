package com.example.coursescoreapi.controller;

import com.example.coursescoreapi.Repository.CourseEntity;
import com.example.coursescoreapi.model.CourseRequest;
import com.example.coursescoreapi.model.CourseResponse;
import com.example.coursescoreapi.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    Environment env;

    @GetMapping("/check")
    public String check(){
        return "course-core-api is working at " + env.getProperty("local.server.port") + " port";
    }

    @PostMapping
    public CourseResponse createCourse(@Valid @RequestBody CourseRequest courseRequest) {

        return courseService.createCourse(courseRequest);
    }

    @GetMapping("/all")
    public List<CourseResponse> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/api/{userID}")
    public List<CourseEntity> getCoursesByUserId(@PathVariable int userID) {
        return courseService.getCoursesByUserId(userID);
    }

    @GetMapping("/{id}")
    public CourseResponse getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PutMapping("/{id}")
    public CourseResponse updateCourseById(@PathVariable  Long id ,
                                           @Valid @RequestBody CourseRequest courseRequest) {
        return courseService.updateCourseById(courseRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteCourseById(@PathVariable Long id) {
        courseService.deleteCourseById(id);
    }
}
