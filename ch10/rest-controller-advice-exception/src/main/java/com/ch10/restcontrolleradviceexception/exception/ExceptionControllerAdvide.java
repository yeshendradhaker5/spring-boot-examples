package com.ch10.restcontrolleradviceexception.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvide {

    @ExceptionHandler(NotEnoughMoneyException.class)
    public ResponseEntity<ErrorDetails> notEnoughMoneyException(){
        ErrorDetails details = new ErrorDetails();
        details.setMessage("Not Enough Money on the sender's account.");
        return ResponseEntity.badRequest()
                .body(details);
    }

}
