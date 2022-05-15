package com.example.lecturecoreapi.controller;

import com.example.lecturecoreapi.model.LectureEntity;
import com.example.lecturecoreapi.service.LectureService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/lecture")
public class LectureController {

    @Autowired
    LectureService lectureService;

    @PostMapping(value="/" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
    public LectureEntity addLecture(@RequestBody LectureEntity lectureEntity){
        return lectureService.createLecture(lectureEntity);
    }

    @GetMapping("/all")
    public List<LectureEntity> getAll(){
        return lectureService.getAllLectures();
    }

    @GetMapping("/{courseID}")
    public List<LectureEntity> getById(@PathVariable Long courseID){
        return lectureService.getLecturesByCourseID(courseID);
    }

}
