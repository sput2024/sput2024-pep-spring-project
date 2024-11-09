package com.example.service;


import java.util.List;
import com.example.entity.Message;
import com.example.repository.MessageRepository;
import org.springframework.stereotype.Service;
@Service
public class MessageService {

        
    static MessageRepository messageRepository;
    public MessageService(MessageRepository messageRepository){
        MessageService.messageRepository = messageRepository;
    }
    







}
