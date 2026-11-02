package com.ch13.transactioncommit.controller;

import com.ch13.transactioncommit.model.Account;
import com.ch13.transactioncommit.model.TransferRequest;
import com.ch13.transactioncommit.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<String> transferMoney(@RequestBody TransferRequest transferRequest){
        accountService.transferMoney(transferRequest);
        return ResponseEntity.ok("Money has been transferred successfully");
    }

    @GetMapping("/account/{id}")
    public Account getAccountById(@PathVariable Long id){
        return accountService.getAccountById(id);
    }

    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAllAccounts(){
        return ResponseEntity.ok(accountService.getAllAccounts());
    }
}
