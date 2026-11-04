package com.ch15.unitesting_annotation.controller;


import com.ch15.unitesting_annotation.model.Account;
import com.ch15.unitesting_annotation.model.TransferRequest;
import com.ch15.unitesting_annotation.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping
    public void transferMoney(@RequestBody TransferRequest transferRequest){
        accountService.transferMoney(transferRequest.getSenderId(), transferRequest.getReceiverId(), transferRequest.getAmount());
    }

    @GetMapping("/account/{name}")
    public List<Account> getAccountsByName(@RequestParam String name){
        return accountService.getAccountsByName(name);
    }

    @GetMapping("/accounts")
    public Iterable<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/account/{id}")
    public Account getAccountById(@PathVariable Long id){
        return accountService.getAccountById(id);
    }
}
