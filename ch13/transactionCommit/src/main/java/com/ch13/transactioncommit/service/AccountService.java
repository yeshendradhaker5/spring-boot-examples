package com.ch13.transactioncommit.service;

import com.ch13.transactioncommit.model.Account;
import com.ch13.transactioncommit.model.TransferRequest;
import com.ch13.transactioncommit.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Logger;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private Logger logger = Logger.getLogger(AccountService.class.getName());

    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(TransferRequest request){
       try {
           Account senderAccount = accountRepository.getAccountById(request.getSenderId());
           Account receiverAccount = accountRepository.getAccountById(request.getReceiverId());

           BigDecimal updatedSenderBalance = senderAccount.getBalance().subtract(request.getAmount());
           BigDecimal updatedReceiverBalance = receiverAccount.getBalance().add(request.getAmount());

           accountRepository.updateAmount(request.getSenderId(), updatedSenderBalance);
           accountRepository.updateAmount(request.getReceiverId(), updatedReceiverBalance);
           throw new RuntimeException("Something got failed");
       }
       catch (Exception e){
            logger.info("Transfer Money Exception handled, message "+ e.getMessage());
       }
    }

    public Account getAccountById(Long id){
        return accountRepository.getAccountById(id);
    }

    public List<Account> getAllAccounts(){
        return accountRepository.getAllAccounts();
    }

}
