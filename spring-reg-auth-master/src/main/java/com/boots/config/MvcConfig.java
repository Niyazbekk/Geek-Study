package com.boots.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/studentsCourses").setViewName("studentsCourses");
        registry.addViewController("/myAccount").setViewName("myAccount");
        registry.addViewController("/myCourses").setViewName("myCourses");
        registry.addViewController("/about").setViewName("about");
        registry.addViewController("/coursePage").setViewName("coursePage");
        registry.addViewController("/teachersPage").setViewName("teachersPage");
        registry.addViewController("/teachersCourse").setViewName("teachersCourse");
        registry.addViewController("/TeacherCoursePage").setViewName("TeacherCoursePage");
    }
}
