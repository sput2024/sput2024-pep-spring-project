package com.example.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;


import com.example.entity.Account;
import com.example.repository.AccountRepository;
import com.example.service.AccountService;

import java.util.ArrayList;
import java.util.List;


/** Spring Social Media Project
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */

@Controller
@RequestMapping("/register")

public class SocialMediaController {
 
  
   // @SuppressWarnings("static-access")
  //  @PostMapping("/register")
  //  public ResponseEntity register(@PathVariable Account account) 
    @GetMapping(value = "/register", params = {"username", "password"})
    public ResponseEntity <?> getSearchFormatAndAmount(@RequestParam String username,@RequestParam String password){
        // Logic to register a new user
         //String username2 = account.getUsername();
      //  String password = account.getUsername();
     // account.setUsername(username);
       System.out.println("TESTING!!!!!!");
       System.out.println(AccountService.getAllAccounts());
        if (username==null||username.isEmpty()){
            return ResponseEntity.status(400).body("error");
        }
        if (password==null||password.length()<4){
            return ResponseEntity.status(400).body("error");
        }
        if (AccountService.getAccountByUsername(username)==true){
            return ResponseEntity.status(409).body("error");
        }
  
        Account accountRegistered = AccountService.Register(username,password);
        return ResponseEntity.status(200).body(accountRegistered);

    }


}
