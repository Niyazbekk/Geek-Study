package com.example.lecturecoreapi.repository;

import com.example.lecturecoreapi.model.LectureEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LectureRepository extends CrudRepository<LectureEntity,Long> {
    List<LectureEntity> getLectureEntitiesByCourseID(Long courseID);
}
