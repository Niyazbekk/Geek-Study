package com.example.messagecoreapi.repository;

import com.example.messagecoreapi.model.MessageModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends CrudRepository<MessageModel, Long> {

    List<MessageModel> getMessageModelsByCourseID(String courseID);

    }
