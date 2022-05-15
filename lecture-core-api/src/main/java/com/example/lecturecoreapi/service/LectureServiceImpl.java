package com.example.lecturecoreapi.service;

import com.example.lecturecoreapi.model.LectureEntity;
import com.example.lecturecoreapi.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureServiceImpl implements LectureService{

    @Autowired
    LectureRepository lectureRepository;

    @Override
    public LectureEntity createLecture(LectureEntity lectureEntity) {
        return lectureRepository.save(lectureEntity);
    }

    @Override
    public List<LectureEntity> getAllLectures() {
        return (List<LectureEntity>) lectureRepository.findAll();
    }

    @Override
    public List<LectureEntity> getLecturesByCourseID(Long courseID) {
        return lectureRepository.getLectureEntitiesByCourseID(courseID);
    }
}
