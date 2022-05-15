package com.example.lecturecoreapi.service;

import com.example.lecturecoreapi.model.Attachment;
import com.example.lecturecoreapi.model.ResponseData;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public interface AttachmentService {
    Attachment saveAttachment(MultipartFile file , Long courseID) throws Exception;

    Attachment getAttachment(String fileId) throws Exception;

    List<Attachment> getIdByCourseID(Long courseID) throws Exception;
}
