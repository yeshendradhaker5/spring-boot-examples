package com.ch14.springdata.service;

import com.ch14.springdata.exception.AccountNotFoundException;
import com.ch14.springdata.model.Account;
import com.ch14.springdata.model.TransferRequest;
import com.ch14.springdata.repository.AccountRepository;
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
    public void transferMoney(TransferRequest request){

        Account sender = accountRepository.findById(request.getSenderId())
                .orElseThrow(() -> new AccountNotFoundException("Sender account not found"));

        Account receiver = accountRepository.findById(request.getReceiverId())
                .orElseThrow(() -> new AccountNotFoundException("Receiver account not found"));

        BigDecimal updatedSenderBalance = sender.getBalance().subtract(request.getAmount());
        BigDecimal updatedReceiverBalance = receiver.getBalance().add(request.getAmount());

        accountRepository.updateAmount(request.getSenderId(), updatedSenderBalance);
        accountRepository.updateAmount(request.getReceiverId(), updatedReceiverBalance);
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
