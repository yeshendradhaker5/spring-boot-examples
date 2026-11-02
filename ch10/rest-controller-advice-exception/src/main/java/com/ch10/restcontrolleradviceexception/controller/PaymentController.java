package com.ch10.restcontrolleradviceexception.controller;

import com.ch10.restcontrolleradviceexception.dto.PaymentDetails;
import com.ch10.restcontrolleradviceexception.service.PaymentService;
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
    public ResponseEntity<PaymentDetails> processPayment(){
        PaymentDetails details = paymentService.processPayment();
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(details);
    }

}
