package com.example.service;

import java.util.*;
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
    

   public static Message CreateMessage(Message message){
    Message message1 = new Message(); //classroomOptional.get();
   // message1.setMessageText(message.getMessageText());
  //  message1.setPostedBy(message.getPostedBy());
    
    return message1;
   }

   public static String searchMessageByID(int ID){
    String val = "yes";
    List<Message> messages = messageRepository.findAll();;
    Message message1 = new Message(); //classroomOptional.get();
   // message1.setMessageText(message.getMessageText());
   // message1.setPostedBy(message.getPostedBy());

    for (int i = 0; i < messages.size();i++){
        Object or = messages.get(i);
        
        Integer temp = ((Message) or).getPostedBy();

        if (temp.equals(ID)){
           return val;
        }
    }


    val = "no";
    return val;
   }

   public static Message addMessage(Message message){
    return messageRepository.save(message);
}


















}
