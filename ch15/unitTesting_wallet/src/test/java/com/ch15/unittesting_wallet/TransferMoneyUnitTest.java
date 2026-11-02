package com.ch15.unittesting_wallet;

import com.ch15.unittesting_wallet.model.Account;
import com.ch15.unittesting_wallet.model.TransferRequest;
import com.ch15.unittesting_wallet.repository.AccountRepository;
import com.ch15.unittesting_wallet.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.awaitility.Awaitility.given;
import static org.mockito.Mockito.mock;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

public class TransferMoneyUnitTest {

    @Test
    @DisplayName("Test if the account is created and amount is transferred if no exception occurs")
    public void moneyTransferHappyFlow(){
        AccountRepository accountRepository = mock(AccountRepository.class);

        AccountService accountService = new AccountService(accountRepository);

        Account sender = new Account();
        sender.setId(1L);
        sender.setName("John");
        sender.setBalance(BigDecimal.valueOf(1000));

        Account receiver = new Account();
        receiver.setId(1L);
        receiver.setName("John");
        receiver.setBalance(BigDecimal.valueOf(1000));

        TransferRequest request = new TransferRequest();
        request.setSenderId(sender.getId());
        request.setReceiverId(receiver.getId());
        request.setAmount(BigDecimal.valueOf(10));

        given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));
        given(accountRepository.findById(receiver.getId())).willReturn(Optional.of(receiver));

        accountService.transferMoney(request);

        verify(accountRepository).updateAmount(1L, BigDecimal.valueOf(990));
        verify(accountRepository).updateAmount(receiver.getId(), BigDecimal.valueOf(1010));

    }
}
