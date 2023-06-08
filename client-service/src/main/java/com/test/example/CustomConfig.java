package com.test.example;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
public class CustomConfig {

    @Bean
    ServiceInstanceListSupplier serviceInstanceListSupplier(ConfigurableApplicationContext context) {
        return ServiceInstanceListSupplier
                .builder()
                .withBlockingDiscoveryClient()
                .withBlockingHealthChecks(new RestTemplate())
                .build(context);
    }

}
