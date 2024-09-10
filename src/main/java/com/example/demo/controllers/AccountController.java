package com.example.demo.controllers;

import com.example.demo.entities.Account;
import com.example.demo.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@CrossOrigin
public class AccountController {
    @Autowired
    private AccountService accountService;


    @GetMapping
    public List<Account> getAllAccounts(){
      return accountService.retrieveAllAccounts();
    }

    @PostMapping
    public void createAccount(@RequestBody Account account){
        accountService.saveAccount(account);
    }

    @GetMapping("/{id}")
    public Account findAccountById(@PathVariable int id){
        return accountService.findAccountById(id);
    }
}
