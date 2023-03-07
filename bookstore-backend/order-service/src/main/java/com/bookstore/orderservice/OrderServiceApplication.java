package com.bookstore.orderservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = {"com.bookstore.orderservice.*"})
@EntityScan(basePackages = {"com.bookstore.orderservice.*",
        "org.axonframework.eventhandling.*",
        "org.axonframework.commandhandling.*",
        "org.axonframework.modelling.*"})
@EnableJpaRepositories
public class OrderServiceApplication {
    @GetMapping("/heal-check")
    String healCheck() {
        return "Catalog-service working";
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
