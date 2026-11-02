package com.ch10.restcontrolleradviceexception.service;

import com.ch10.restcontrolleradviceexception.dto.PaymentDetails;
import com.ch10.restcontrolleradviceexception.exception.NotEnoughMoneyException;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public PaymentDetails processPayment(){
        throw new NotEnoughMoneyException();
    }

}
