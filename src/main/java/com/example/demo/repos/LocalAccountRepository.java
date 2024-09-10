package com.example.demo.repos;

import com.example.demo.entities.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Repository
public class LocalAccountRepository implements AccountRepository {
    List<Account> accounts;

    public LocalAccountRepository(){

        accounts = new ArrayList<>();
        accounts.add(new Account(1,"Georgito1 Saint Hilaire",0.12));
        accounts.add(new Account(2,"Georgito2 Saint Hilaire",0.122));
        accounts.add(new Account(3,"Georgito3 Saint Hilaire",0.123));
        accounts.add(new Account(4,"Georgito4 Saint Hilaire",0.124));
        accounts.add(new Account(5,"Georgito5 Saint Hilaire",0.125));



    }

    @Override
    public List<Account> getAllAccounts() {
        return  accounts;
    }

    @Override
    public Account findAccountById(int id) {
        return accounts.stream().filter(account -> account.getId() ==id).findFirst().orElse(null);
    }

    @Override
    public void saveAccount(Account account) {
        accounts.add(account);
    }

    @Override
    public void batchInsert(List<Account> accounts) {

    }


}
