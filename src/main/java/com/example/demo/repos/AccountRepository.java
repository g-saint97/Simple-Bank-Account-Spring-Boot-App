package com.example.demo.repos;
import java.util.List;

import com.example.demo.entities.Account;

public interface AccountRepository {
    List<Account> getAllAccounts();
    Account findAccountById(int id);
    void saveAccount(Account account);
    void batchInsert(List<Account> accounts);

}
