package com.example.demo.services;

import com.example.demo.entities.Account;
import com.example.demo.repos.AccountRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocalAccountService implements AccountService{

    private AccountRepository accountRepository;

    Logger logger = LoggerFactory.getLogger(LocalAccountService.class);
    public LocalAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> retrieveAllAccounts() {
        return accountRepository.getAllAccounts();
    }

    @Override
public List<Account> retrieveAllAccount(){
        logger.info("Retrieving all accounts");
        return accountRepository.getAllAccounts();
    }

    @Override
    public Account findAccountById(int id) {
        return accountRepository.findAccountById(id);
    }

    @Override
    public void saveAccount(Account account) {
        accountRepository.saveAccount(account);
    }

}
