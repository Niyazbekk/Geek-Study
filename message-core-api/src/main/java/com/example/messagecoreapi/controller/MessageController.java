package com.example.messagecoreapi.controller;

import com.example.messagecoreapi.model.MessageModel;
import com.example.messagecoreapi.repository.MessageRepository;
import com.example.messagecoreapi.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8082")
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping("/chats")
    public MessageModel postChat(@Valid @RequestBody MessageModel messageModel) {
        return messageService.createMessage(messageModel);
    }

    @GetMapping("/{courseID}")
    public List<MessageModel> streamMessages(@RequestParam String courseID) {
        return messageService.getMessagesByCourseId(courseID);
    }
}
