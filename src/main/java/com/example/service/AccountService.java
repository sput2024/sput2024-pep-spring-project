package com.example.service;
import java.util.*;

import java.util.List;
import com.example.entity.Account;
import com.example.repository.AccountRepository;
import org.springframework.stereotype.Service;
// Spring Social Media Project
@Service
public class AccountService {
    
    private static final Boolean False = null;
    private static final Boolean True = null;
    static AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository){
        AccountService.accountRepository = accountRepository;
      
    }
    

    public static Account addAccount(Account account){
        return accountRepository.save(account);
    }
    
    public static String getAccountByUsername(Account account){
        String val = "False";
        List<Account> accounts = getAllAccounts();
        
        for (int i = 0; i < accounts.size();i++){
            Object or = accounts.get(i);
            
            String temp = ((Account) or).getUsername();
           
            String tempTwo = account.getUsername();
          
            if (temp.equals(tempTwo)){
                val = "True";
              
                return val;
            }
        }
        return val;
    }

    public static Object verifyLogin(Account account){
        String username = account.getUsername();
        String password = account.getPassword();
        String val = "False";
        List<Account> accounts = getAllAccounts();
        
        for (int i = 0; i < accounts.size();i++){
            Object or = accounts.get(i);
            
            String temp = ((Account) or).getUsername();

            String tempPass = ((Account) or).getPassword();
           
          
            if (temp.equals(username)&&tempPass.equals(password)){
              
                return or;
            }
        }
        return null;
    }




      

    public static Account Register(Account account){
       
            Account account1 = new Account(); //classroomOptional.get();
            account1.setUsername(account.getUsername());
            account1.setPassword(account.getPassword());
            accountRepository.save(account1);
          
            return account1;
    }

    public static List<Account> getAllAccounts() {
       
        return accountRepository.findAll();
    }


}
