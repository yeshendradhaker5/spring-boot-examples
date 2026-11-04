package com.ch15.integrationtesting;

import com.ch15.integrationtesting.model.Account;
import com.ch15.integrationtesting.repository.AccountRepository;
import com.ch15.integrationtesting.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class IntegrationTestingApplicationTests {

    @MockitoBean
    private AccountRepository accountRepository;

    private final AccountService accountService;

    @Autowired
    public IntegrationTestingApplicationTests(AccountService accountService){
        this.accountService = accountService;
    }

    @Test
    void testMoneyTransfer(){
        Account sender = new Account();
        sender.setId(1L);
        sender.setBalance(BigDecimal.valueOf(100));

        Account receiver = new Account();
        receiver.setId(1L);
        receiver.setBalance(BigDecimal.valueOf(100));

        when(accountRepository.findById(sender.getId()))
                .thenReturn(Optional.of(sender));
        when(accountRepository.findById(receiver.getId()))
                .thenReturn(Optional.of(receiver));

        accountService.transferMoney(sender.getId(), receiver.getId(), BigDecimal.valueOf(10));

        verify(accountRepository).updateAmount(sender.getId(), BigDecimal.valueOf(90));
        verify(accountRepository).updateAmount(receiver.getId(), BigDecimal.valueOf(110));
    }

}
