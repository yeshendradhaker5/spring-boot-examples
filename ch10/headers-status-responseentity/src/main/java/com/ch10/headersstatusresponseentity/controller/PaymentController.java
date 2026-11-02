package com.ch10.headersstatusresponseentity.controller;

import com.ch10.headersstatusresponseentity.dto.PaymentDetails;
import org.springframework.aop.support.AopUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class PaymentController {

    private Logger logger = Logger.getLogger(PaymentController.class.getName());

    @GetMapping("/payment")
    public ResponseEntity<PaymentDetails> processPayment(){
        PaymentDetails details = new PaymentDetails();
        details.setAmount(1000L);
        details.setPaymentId("102L");

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("PaymentMode", "UPI")
                .header("Bank Name", "ICICI")
                .header("paymentId", details.getPaymentId())
                .body(details);
    }

}
