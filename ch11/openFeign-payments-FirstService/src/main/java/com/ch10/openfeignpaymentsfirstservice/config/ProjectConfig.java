package com.ch10.openfeignpaymentsfirstservice.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.ch10.openfeignpaymentsfirstservice.proxy")
public class ProjectConfig {
}
