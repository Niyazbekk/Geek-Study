package com.example.enrollmentcoreapi.Repository;

import com.example.enrollmentcoreapi.model.EnrollmentResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface EnrollmentRepository extends CrudRepository<EnrollmentEntity,Long> {
    EnrollmentEntity getEnrollmentEntityByCourseID(Long course_id);

    List<EnrollmentResponse> getEnrollmentEntitiesByUserID(Long id);

    List<EnrollmentEntity> findByUserID(Long user_id);

    @Transactional
    void deleteEnrollmentEntityById(Long id);

    List<EnrollmentEntity> getEnrollmentEntityBy();
}
