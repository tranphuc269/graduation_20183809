package com.bookstore.notificationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = {"com.bookstore.notificationservice.*"})
@EntityScan(basePackages = {"com.bookstore.notificationservice.*",
        "org.axonframework.eventhandling.tokenstore.*"})
@EnableJpaRepositories
public class NotificationServiceApplication {
    @GetMapping("/heal-check")
    String healCheck() {
        return "Catalog-service working";
    }

    public static void main(String[] args) {
        SpringApplication.run(NotificationServiceApplication.class, args);
    }
}
