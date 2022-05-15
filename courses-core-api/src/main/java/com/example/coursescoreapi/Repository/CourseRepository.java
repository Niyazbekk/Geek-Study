package com.example.coursescoreapi.Repository;

import com.example.coursescoreapi.model.CourseResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<CourseEntity,Long> {
    List<CourseEntity> getCourseEntitiesByUserID(int userID);

    CourseEntity getCourseEntityById(Long id);

    @Transactional
    void deleteCourseEntityById(Long id);

    List<CourseEntity> getCourseEntityBy();
}
