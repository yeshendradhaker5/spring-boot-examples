package com.ch10.exceptionresponse.controller;

import com.ch10.exceptionresponse.dto.PaymentDetails;
import com.ch10.exceptionresponse.exception.ErrorDetails;
import com.ch10.exceptionresponse.exception.NotEnoughMoneyException;
import com.ch10.exceptionresponse.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @PostMapping("/payment")
    public ResponseEntity<?> processPayment(){

        try {
            PaymentDetails details = paymentService.processPayment();
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body(details);
        }
        catch (NotEnoughMoneyException e){
            ErrorDetails details = new ErrorDetails();
            details.setMessage("Not Enough Money");
            return ResponseEntity.badRequest()
                    .body(details);
        }
    }
}
