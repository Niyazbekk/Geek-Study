package com.boots.controller;

import com.boots.entity.User;
import com.boots.repository.UserRepository;
import com.boots.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StudentCourseController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/studentPage")
    public String studentPage(HttpServletRequest request){
        if (request.isUserInRole("ROLE_TEACHER")) {
            return "redirect:/teachersPage/";
        }
        return "studentsCourses";
    }

    @GetMapping("/myAccount")
    public String myAcc(){
        return "myAccount";
    }

    @GetMapping("/myCourses")
    public String myCourses(){
        return "myCourses";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/teachersPage")
    public String teach(){
        return "teachersPage";
    }

    @GetMapping("/coursePage/{id}")
    public String coursePage(@PathVariable Long id){
        return "coursePage";
    }


    @GetMapping("/TeacherCoursePage/{id}")
    public String teacherP(@PathVariable Long id){
        return "TeacherCoursePage";
    }

}
