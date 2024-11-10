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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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

          //    if (AccountService.getAccountByUsername(username)==true){
    ///        return ResponseEntity.status(409).body("error");
    //    }
        System.out.println("testing!!!!!!!!!!!!!!!!");
      //  return "ID: " + username;
      Account accountRegistered = AccountService.Register(account);
      return ResponseEntity.status(200).body(accountRegistered);
   
    }
}
    
 


