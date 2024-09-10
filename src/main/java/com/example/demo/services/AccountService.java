package com.example.demo.services;
import java.util.List;
import com.example.demo.entities.Account;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {
    List<Account> retrieveAllAccounts();


    List<Account> retrieveAllAccount();
    Account findAccountById(int id);
    void saveAccount(Account account);
}
