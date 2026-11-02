package com.ch10.exceptionresponse.service;

import com.ch10.exceptionresponse.dto.PaymentDetails;
import com.ch10.exceptionresponse.exception.NotEnoughMoneyException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment(){
        throw new NotEnoughMoneyException();
    }
}
