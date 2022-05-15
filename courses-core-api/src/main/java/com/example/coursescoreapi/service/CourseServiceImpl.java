package com.example.coursescoreapi.service;

import com.example.coursescoreapi.Repository.CourseRepository;
import com.example.coursescoreapi.Repository.CourseEntity;
import com.example.coursescoreapi.model.CourseRequest;
import com.example.coursescoreapi.model.CourseResponse;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public CourseResponse createCourse(CourseRequest courseRequest) {
        CourseEntity courseEntity = modelMapper.map(courseRequest,CourseEntity.class);
        courseEntity = courseRepository.save(courseEntity);
        return modelMapper.map(courseEntity,CourseResponse.class);
    }

    @Override
    public List<CourseResponse> getAllCourses() {

        return courseRepository.getCourseEntityBy().stream()
                .map(course -> modelMapper.map(course,CourseResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public CourseResponse getCourseById(Long id) {
        CourseEntity courseEntity = courseRepository.getCourseEntityById(id);
        return modelMapper.map(courseEntity, CourseResponse.class);
    }

    @Override
    public List<CourseEntity> getCoursesByUserId(int userID) {
        //CourseEntity courseEntity = courseRepository.getCourseEntityByUserID(user_id);
        //return modelMapper.map(courseEntity, CourseResponse.class);
        return courseRepository.getCourseEntitiesByUserID(userID);
    }

    @Override
    public CourseResponse updateCourseById(CourseRequest courseRequest) {
        CourseEntity courseEntity = modelMapper.map(courseRequest, CourseEntity.class);
        courseEntity = courseRepository.save(courseEntity);
        return modelMapper.map(courseEntity, CourseResponse.class);
    }

    @Override
    public void deleteCourseById(Long id) {
        courseRepository.deleteCourseEntityById(id);
    }
}
