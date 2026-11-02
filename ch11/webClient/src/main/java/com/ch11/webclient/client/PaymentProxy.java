package com.ch11.webclient.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import com.ch11.webclient.model.Payment;

@Component
public class PaymentProxy {

    private final WebClient webClient;

    @Value("${name.service.url}")
    private String path;

    public PaymentProxy(WebClient webClient){
        this.webClient = webClient;
    }

    public Mono<Payment> createPayment(Payment payment, String requestId){
        return webClient.post()
                .uri(path+"/payment")
                .header("requestId", requestId)
                .body(Mono.just(payment), Payment.class) // can also use bodyValue(payment) as i am already getting payment object
                .retrieve()
                .bodyToMono(Payment.class);
    }
}
