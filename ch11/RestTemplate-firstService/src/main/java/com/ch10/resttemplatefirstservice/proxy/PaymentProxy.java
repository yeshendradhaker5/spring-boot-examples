package com.ch10.resttemplatefirstservice.proxy;

import com.ch10.resttemplatefirstservice.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
public class PaymentProxy {

    private final RestTemplate restTemplate;

    @Value("${name.service.url}")
    private String path;

    public PaymentProxy(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Payment processPayment(Payment payment){
        String uri = path + "/payment";
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("requestId", UUID.randomUUID().toString());

        HttpEntity<Payment> httpEntity = new HttpEntity<>(payment, httpHeaders);

        ResponseEntity<Payment> paymentEntity = restTemplate.exchange(
                uri,
                HttpMethod.POST,
                httpEntity,
                Payment.class
        );

        return paymentEntity.getBody();
    }
}
