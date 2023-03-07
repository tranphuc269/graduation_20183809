package com.bookstore.paymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ComponentScan(basePackages = {"com.bookstore.paymentservice.*"})
@EntityScan(basePackages = {"com.bookstore.paymentservice.*", "org.axonframework.eventhandling.tokenstore.*"})
@EnableJpaRepositories
public class PaymentServiceApplication {

	@GetMapping("/heal-check")
	String healCheck(){
		return "payment-service working";
	}

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceApplication.class, args);
	}

}
