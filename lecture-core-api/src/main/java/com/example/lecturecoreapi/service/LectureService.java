package com.example.lecturecoreapi.service;

import com.example.lecturecoreapi.model.LectureEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface LectureService {

    LectureEntity createLecture(LectureEntity lectureEntity);

    List<LectureEntity> getAllLectures();

    List<LectureEntity> getLecturesByCourseID(Long courseID);

}
