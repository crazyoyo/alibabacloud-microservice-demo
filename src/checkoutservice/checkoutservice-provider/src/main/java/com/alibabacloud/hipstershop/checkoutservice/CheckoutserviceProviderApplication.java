package com.alibabacloud.hipstershop.checkoutservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@EnableDubbo
@SpringBootApplication
public class CheckoutserviceProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(CheckoutserviceProviderApplication.class, args);
    }
}
