package com.example.lecturecoreapi.repository;

import com.example.lecturecoreapi.model.Attachment;
import com.example.lecturecoreapi.model.ResponseData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachment, String>  {
    List<Attachment> getAttachmentsByCourseID(Long courseID);
}
