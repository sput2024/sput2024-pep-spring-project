package com.example.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;
import com.example.service.AccountService;
import com.example.service.MessageService;

import java.util.ArrayList;
import java.util.List;


/** Spring Social Media Project
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */

@Controller
public class SocialMediaController {
    @RequestMapping(value="/register", method = RequestMethod.POST)
    @ResponseBody
   //public Account register(Account account) {
    public ResponseEntity<Account> register(@RequestBody Account account) {
        if (account.getUsername()==null||account.getUsername().isEmpty()){
                return ResponseEntity.status(400).body(null);
               }
        if (account.getPassword()==null||account.getPassword().length()<4){
           return ResponseEntity.status(400).body(null);
          }
        if (AccountService.getAccountByUsername(account).equals("True")){
      
            return ResponseEntity.status(409).body(null);
             }

        if (AccountService.getAccountByUsername(account).equals("False")){ 
            Account accountRegistered = AccountService.Register(account);
            AccountService.addAccount(accountRegistered);
            return ResponseEntity.status(200).body(accountRegistered);} 
        
        return ResponseEntity.status(400).body(null);
}

@RequestMapping(value="/login", method = RequestMethod.POST)
@ResponseBody
public ResponseEntity<Object> verifyLogin(@RequestBody Account account) {
   Object orOne;
   orOne = AccountService.verifyLogin(account);   
  if (orOne!=null){ 
    
    return ResponseEntity.status(200).body(orOne);
  } 

  return ResponseEntity.status(401).body(null);

}

@RequestMapping(value="/messages", method = RequestMethod.POST)
@ResponseBody
public ResponseEntity<Message> createMessage(@RequestBody Message message) {
  System.out.println(message.getPostedBy());
  if (message.getMessageText().length()<=255&&message.getMessageText().isEmpty()==false&&message.getPostedBy()>=0){ 
     // Message messageCreated = MessageService.CreateMessage(message);
     
     String val;
     val = MessageService.searchMessageByID(message.getPostedBy());

     if (val.equals("yes")){
         MessageService.addMessage(message);
         return ResponseEntity.status(200).body(message);
  } 
}

  if (message.getPostedBy()==null){ 
     Message messageCreated = MessageService.CreateMessage(message);
     MessageService.addMessage(messageCreated);

   return ResponseEntity.status(200).body(message);
 } 


  return ResponseEntity.status(400).body(null);

}



@RequestMapping(value="/messages", method = RequestMethod.GET)
@ResponseBody
public ResponseEntity <List<Message>> getAllMessages() {
  
   
   List<Message> messageList = MessageService.getAllMessages();
   return ResponseEntity.status(200).body(messageList);

}


@RequestMapping(value="/messages/{messageId}", method = RequestMethod.GET)
@ResponseBody
public ResponseEntity<Message> getMessageById(@PathVariable("messageId") Integer messageId) {

   
   String val= MessageService.verifyMessageById(messageId);
  
if (val=="no"){
  return ResponseEntity.status(200).body(null);
}
   Message message1= MessageService.getMessageById(messageId);
   return ResponseEntity.status(200).body(message1);

}




@DeleteMapping(value="/messages/{messageId}")
//@ResponseBody
public ResponseEntity<Integer> DeleteMessageById(@PathVariable(value = "messageId") Integer messageId) {
  System.out.println("testing!!!!!");
  System.out.println(messageId);
  Integer val1=1;
  String val= MessageService.verifyMessageById(messageId);
  System.out.println(val);
  
if (val=="no"){
  return ResponseEntity.status(200).body(null);
}
   val1= MessageService.DeleteMessageById(messageId);
   return ResponseEntity.status(200).body(val1);

}













}

    
 


