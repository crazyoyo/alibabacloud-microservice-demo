package com.alibabacloud.hipstershop.cartserviceprovider;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@EnableDubbo
@SpringBootApplication
public class CartserviceProviderBootstrap {

    public static void main(String[] args) {
        new SpringApplicationBuilder(CartserviceProviderBootstrap.class)
                .run(args);
    }
}