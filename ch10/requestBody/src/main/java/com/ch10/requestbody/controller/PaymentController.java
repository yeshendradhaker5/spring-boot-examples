package com.ch10.requestbody.controller;

import com.ch10.requestbody.dto.PaymentDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @PostMapping("/payment")
    public ResponseEntity<PaymentDetails> processPayment(@RequestBody PaymentDetails details){
        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .body(details);
    }


}
