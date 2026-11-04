package com.ch15.unittestingreturnstatement.service;

import com.ch15.unittestingreturnstatement.model.Account;
import com.ch15.unittestingreturnstatement.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public Account signUp(String username, String name, String password){
        Account account = new Account();
        account.setName(name);
        account.setUsername(username);
        account.setPassword(password);

        return accountRepository.save(account);
    }

    public Boolean login(String username, String password){
        boolean isLoggedIn = loginProcessor(username, password);
        return isLoggedIn;
    }

    private boolean loginProcessor(String username, String password){
        if(username.equals("John") && password.equals("JohnDoe")) {
            return true;
        }
        else {
            return false;
        }
    }
}
