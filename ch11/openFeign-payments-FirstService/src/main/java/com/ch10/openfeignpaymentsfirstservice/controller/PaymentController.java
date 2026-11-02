package com.ch10.openfeignpaymentsfirstservice.controller;

import com.ch10.openfeignpaymentsfirstservice.model.Payment;
import com.ch10.openfeignpaymentsfirstservice.proxy.PaymentProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    private final PaymentProxy paymentProxy;

    public PaymentController(PaymentProxy paymentProxy){
        this.paymentProxy = paymentProxy;
    }

    @PostMapping("/payment")
    public ResponseEntity<Payment> makePayment(
            @RequestBody Payment payment,
            @RequestHeader String requestId){

        Payment paymentResponse = paymentProxy.processPayment(payment,requestId);

        return ResponseEntity.status(HttpStatus.OK)
                .body(paymentResponse);
    }

}
