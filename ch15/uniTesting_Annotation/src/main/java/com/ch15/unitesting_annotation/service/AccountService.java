package com.ch15.unitesting_annotation.service;

import com.ch15.unitesting_annotation.exception.AccountNotFoundException;
import com.ch15.unitesting_annotation.model.Account;
import com.ch15.unitesting_annotation.model.TransferRequest;
import com.ch15.unitesting_annotation.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(Long senderId, Long receiverId, BigDecimal amount){

        Account sender = accountRepository.findById(senderId)
                .orElseThrow(() -> new AccountNotFoundException("Sender account not found"));

        Account receiver = accountRepository.findById(receiverId)
                .orElseThrow(() -> new AccountNotFoundException("Receiver account not found"));

        BigDecimal updatedSenderBalance = sender.getBalance().subtract(amount);
        BigDecimal updatedReceiverBalance = receiver.getBalance().add(amount);

        accountRepository.updateAmount(senderId, updatedSenderBalance);
        accountRepository.updateAmount(receiverId, updatedReceiverBalance);
    }

    public List<Account> getAccountsByName(String name){
        return accountRepository.getAccountsByName(name);
    }

    public Iterable<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id){
        return accountRepository.findById(id).orElseThrow(
                () -> new AccountNotFoundException("Account not found")
        );
    }

}
