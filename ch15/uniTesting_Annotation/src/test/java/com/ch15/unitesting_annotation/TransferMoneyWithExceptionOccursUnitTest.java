package com.ch15.unitesting_annotation;

import com.ch15.unitesting_annotation.exception.AccountNotFoundException;
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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TransferMoneyWithExceptionOccursUnitTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    @Test
    @DisplayName("Transfer money with exception: Account not found.")
    public void transferMoneyWithException(){
        Account sender = new Account();
        sender.setId(1L);
        sender.setBalance(BigDecimal.valueOf(100));

        Account receiver = new Account();
        receiver.setId(2L);
        receiver.setBalance(BigDecimal.valueOf(50));

        given(accountRepository.findById(sender.getId())).willReturn(Optional.of(sender));
        given(accountRepository.findById(receiver.getId())).willReturn(Optional.empty());

        assertThrows(AccountNotFoundException.class, () -> accountService.transferMoney(
                sender.getId(), receiver.getId(), BigDecimal.valueOf(10)
        ));

        verify(accountRepository, never()).updateAmount(sender.getId(), BigDecimal.valueOf(10));

    }

}
