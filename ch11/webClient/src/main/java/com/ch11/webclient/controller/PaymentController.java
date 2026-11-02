package com.ch11.webclient.controller;

import com.ch11.webclient.client.PaymentProxy;
import com.ch11.webclient.model.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PaymentController {

    private final PaymentProxy paymentProxy;

    public PaymentController(PaymentProxy paymentProxy){
        this.paymentProxy = paymentProxy;
    }

    @PostMapping("/payment")
    public Mono<Payment> processPayment(
            @RequestBody Payment payment,
            @RequestHeader String requestId){
        Mono<Payment> paymentMono = paymentProxy.createPayment(payment, requestId);
        return paymentMono;
    }

}
