package com.example.service;


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
    

    public Account addAccount(Account account){
        return accountRepository.save(account);
    }
    
    public static Boolean getAccountByUsername(String username){
        Boolean val = False;
        List<Account> accounts = getAllAccounts();
        for (int i=0; i < accounts.size();i++){
        if (accounts(1).get(i).contains(username)){
            val = True;
            return val;
        }
        }
  //   if(Account.account(username)==null){
   //     return true;
  //   }
            return val;
    }

    public static Account Register(String username, String password){
       // Optional<Classroom> classroomOptional = classroomRepository.findById(classroomId);
       // if(classroomOptional.isPresent()){
              Account account1 = new Account(); //classroomOptional.get();
             
            //account1.setUsername(account.getUsername());
            account1.setUsername(username);
            account1.setUsername(password);
           // account1.setPassword(account.getPassword());
      //      classroomRepository.save(classroom);
            accountRepository.save(account1);
            return account1;
    }

    public static List<Account> getAllAccounts() {
        //System.out.println("test"+accountRepository.findAll());
        return accountRepository.findAll();
    }


}
