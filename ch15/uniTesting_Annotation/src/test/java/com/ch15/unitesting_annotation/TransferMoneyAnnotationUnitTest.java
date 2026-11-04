package com.ch15.unitesting_annotation;

import com.ch15.unitesting_annotation.model.Account;
import com.ch15.unitesting_annotation.repository.AccountRepository;
import com.ch15.unitesting_annotation.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TransferMoneyAnnotationUnitTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Test
    @DisplayName("Test the money is transferred with no exception occurs.")
    public void moneyTransferredWithNoException(){

        Account sender = new Account();
        sender.setId(1L);
        sender.setBalance(BigDecimal.valueOf(100));

        Account receiver = new Account();
        receiver.setId(2L);
        receiver.setBalance(BigDecimal.valueOf(50));

        given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));
        given(accountRepository.findById(receiver.getId())).willReturn(Optional.of(receiver));

        accountService.transferMoney(sender.getId(), receiver.getId(), BigDecimal.valueOf(10));

        verify(accountRepository).updateAmount(sender.getId(), BigDecimal.valueOf(90));
        verify(accountRepository).updateAmount(receiver.getId(), BigDecimal.valueOf(60));

    }
}
