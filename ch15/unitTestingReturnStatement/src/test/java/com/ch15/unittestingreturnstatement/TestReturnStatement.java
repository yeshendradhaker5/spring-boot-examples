package com.ch15.unittestingreturnstatement;

import com.ch15.unittestingreturnstatement.controller.AccountController;
import com.ch15.unittestingreturnstatement.service.AccountService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TestReturnStatement {

    @Mock
    private AccountService accountService;

    @Mock
    private Model model;

    @InjectMocks
    private AccountController accountController;

    @Test
    @DisplayName("The test is to test the return statement with no exception occurs")
    public void testReturnTrue(){
        String username = "John";
        String password = "Doe";

        given(accountService.login(username, password)).willReturn(true);
        String result = accountController.login(username, password, model);
        assertEquals("login.html", result);
        verify(model).addAttribute("login", "Logged in successfully");
    }

    @Test
    @DisplayName("This test is to test the return statement with false output with no exception occurs")
    public void testReturnFalse(){
        String username = "John";
        String password = "Doe";

        given(accountService.login(username, password)).willReturn(false);
        String result = accountController.login(username, password, model);
        assertEquals("login.html", result);
        verify(model).addAttribute("login", "Login failed");
    }
}
