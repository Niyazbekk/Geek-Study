package com.example.studyofficeapi.controller;

import com.example.studyofficeapi.feign.CourseFeign;
import com.example.studyofficeapi.feign.EnrollFeign;
import com.example.studyofficeapi.model.CourseResponse;
import com.example.studyofficeapi.model.EnrollResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/study")
public class StudyOfficeController {

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Autowired
    CourseFeign courseFeign;

    @Autowired
    EnrollFeign enrollFeign;

    @GetMapping("/check")
    public String check(){
        return "study-office-api is working";
    }

    @GetMapping("/course/all")
    public List<CourseResponse> getAllCourses(){
        return courseFeign.getAllCourses();
    }

    @GetMapping("/course/{Id}")
    public CourseResponse getCourseById(@PathVariable Long Id){
        return courseFeign.getCourseById(Id);
    }

    @GetMapping("/course/check")
    public String checkCourse(){
        return courseFeign.checkCourse();
    }

    @GetMapping("/enroll/check")
    String checkEnroll(){
        return enrollFeign.checkEnroll();
    }

    @GetMapping("/enroll/all")
    List<EnrollResponse> getAllEnrollments(){
        return enrollFeign.getAllEnrollments();
    }


    @GetMapping("/enroll/api/{userId}")
    List<CourseResponse> getCoursesByEnrolls(@PathVariable String userId){
        List<CourseResponse> courseResponses = new ArrayList<>();
        List<EnrollResponse> enrollResponses = enrollFeign.getEnrollsByUserId(userId);
        for (EnrollResponse e : enrollResponses){
            courseResponses.add(courseFeign.getCourseById(e.getCourseID()));
        }

        return courseResponses.stream()
                .map(course -> modelMapper.map(course, CourseResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/enroll/{userId}")
    List<EnrollResponse> getEnrollsByUserId(@PathVariable String userId){
        return enrollFeign.getEnrollsByUserId(userId);
    }

}
