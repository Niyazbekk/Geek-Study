package com.example.messagecoreapi.service;

import com.example.messagecoreapi.model.MessageModel;
import com.example.messagecoreapi.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService{
    @Autowired
    MessageRepository messageRepository;

    @Override
    public MessageModel createMessage(MessageModel messageModel) {
        return messageRepository.save(messageModel);
    }

    @Override
    public List<MessageModel> getMessagesByCourseId(String courseID) {
        return messageRepository.getMessageModelsByCourseID(courseID);
    }
}
