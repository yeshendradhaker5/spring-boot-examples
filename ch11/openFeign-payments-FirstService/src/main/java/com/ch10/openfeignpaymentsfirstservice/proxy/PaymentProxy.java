package com.ch10.openfeignpaymentsfirstservice.proxy;

import com.ch10.openfeignpaymentsfirstservice.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "openFeign-payments-secondService", url = "${name.service.url}")
public interface PaymentProxy {

    @PostMapping("/payment")
    Payment processPayment(
            @RequestBody Payment payment,
            @RequestHeader String requestId);

}
