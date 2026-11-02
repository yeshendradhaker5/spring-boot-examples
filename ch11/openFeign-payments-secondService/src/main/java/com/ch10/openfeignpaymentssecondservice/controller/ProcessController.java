package com.ch10.openfeignpaymentssecondservice.controller;

import com.ch10.openfeignpaymentssecondservice.model.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class ProcessController {

    private Logger logger = Logger.getLogger(ProcessController.class.getName());

    @PostMapping("/payment")
    public ResponseEntity<Payment> processPayment(
            @RequestBody Payment payment,
            @RequestHeader String requestId){

        logger.info("Request Received with id "+ requestId+ " and amount of "+payment.getAmount());
        logger.info("Payment id "+payment.getPId());
        return ResponseEntity.status(HttpStatus.OK)
                .body(payment);

    }


}
