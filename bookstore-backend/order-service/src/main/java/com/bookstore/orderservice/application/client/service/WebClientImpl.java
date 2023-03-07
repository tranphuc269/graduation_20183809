package com.bookstore.orderservice.application.client.service;

import com.bookstore.orderservice.application.client.model.VNPayResponseClient;
import com.bookstore.orderservice.application.client.model.request.CreateVNPayRequest;
import com.bookstore.orderservice.application.es.order.query.model.dto.CheckProductQuantity;
import com.bookstore.orderservice.application.es.order.query.model.dto.CheckProductQuantityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class WebClientImpl implements IWebClient {


    private final WebClient.Builder webClientBuilder;

    @Autowired
    public WebClientImpl(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    @Override
    public VNPayResponseClient createPayment(CreateVNPayRequest request, String bearToken) {
        VNPayResponseClient responseClient = webClientBuilder
                .build()
                .post()
                .uri("localhost:8900/payment-service/payments/vnpay-pay")
                .headers(h -> h.setBearerAuth(bearToken))
                .body(Mono.just(request), CreateVNPayRequest.class)
                .retrieve()
                .bodyToMono(VNPayResponseClient.class)
                .block();
        System.out.println("responseClient : " + responseClient);
        return responseClient;
    }

    @Override
    public List<CheckProductQuantityResponse> checkProductQuantity(List<CheckProductQuantity> request, String bearToken) {
        List<CheckProductQuantityResponse> response = webClientBuilder
                .build()
                .post()
                .uri("localhost:8900/catalog-service/product/check-product-quantity")
                .headers(h -> h.setBearerAuth(bearToken))
                .body(Mono.just(request), CreateVNPayRequest.class)
                .retrieve()
                .bodyToFlux(CheckProductQuantityResponse.class)
                .collectList()
                .block();
        return response;
    }
}
