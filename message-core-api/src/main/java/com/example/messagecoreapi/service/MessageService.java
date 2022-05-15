package com.example.messagecoreapi.service;


import com.example.messagecoreapi.model.MessageModel;

import java.util.List;

public interface MessageService {
    MessageModel createMessage(MessageModel messageModel);

    List<MessageModel> getMessagesByCourseId(String courseID);
}
