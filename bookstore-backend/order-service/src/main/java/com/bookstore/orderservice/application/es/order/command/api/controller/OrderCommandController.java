package com.bookstore.orderservice.application.es.order.command.api.controller;


import com.bookstore.orderservice.application.client.model.VNPayResponseClient;
import com.bookstore.orderservice.application.client.model.request.CreateVNPayRequest;
import com.bookstore.orderservice.application.client.service.IWebClient;
import com.bookstore.orderservice.application.es.order.query.model.dto.CheckProductQuantityResponse;
import com.bookstore.orderservice.application.es.order.service.IOrderService;
import com.bookstore.orderservice.common.application.response.dto.BaseResponse;
import com.bookstore.orderservice.common.utils.CommonUtilityMethods;
import com.bookstore.orderservice.application.es.order.command.api.commands.*;
import com.bookstore.orderservice.application.es.order.command.write_model.dto.*;
import com.bookstore.orderservice.utils.PaymentMethod;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@NoArgsConstructor
@RequestMapping("/order")
public class OrderCommandController {


    @Autowired
    private CommandGateway gateway;

    @Autowired
    private IOrderService service;


    @PostMapping
    public ResponseEntity<Object> createOrder(@RequestBody CreateOrderRequest request,
                                            @RequestHeader HttpHeaders headers) {
        String bearToken = CommonUtilityMethods.getTokenFromRequestHeader(headers);
        List<CheckProductQuantityResponse> checkProductQuantities = service.checkProductQuantity(request.getCartId(), bearToken);
        boolean allObjectsAreEnough = checkProductQuantities.stream()
                .allMatch(CheckProductQuantityResponse::isEnough);

        if (!allObjectsAreEnough) {
            return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(checkProductQuantities);
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String userIdFromToken = CommonUtilityMethods.getUserIdFromToken(authentication);
        PaymentMethod paymentMethod;
        if (request.getPaymentMethod()
                .equals(PaymentMethod.COD.name())) {
            paymentMethod = PaymentMethod.COD;
        } else {
            paymentMethod = PaymentMethod.VNPAY;
        }
        CreateOrderCommand command = CreateOrderCommand
                .builder()
                .orderCheckingId(UUID.randomUUID().toString())
                .userId(userIdFromToken)
                .cartId(request.getCartId())
                .paymentMethod(paymentMethod)
                .shippingAddress(request.getAddress())
                .build();
        return ResponseEntity.ok(BaseResponse.ofSucceeded(gateway.sendAndWait(command).toString()));
    }


    @PostMapping("/confirm")
    public BaseResponse<Void> confirmOrder(@RequestBody ConfirmOrderRequest request) {
        ConfirmOrderCommand command = ConfirmOrderCommand
                .builder()
                .orderCheckingId(request.getOrderCheckingId())
//                .orderId(request.getOrderId())
                .build();
        gateway.send(command);
        return BaseResponse.ofSucceeded();
    }

    @PostMapping("/cancel")
    public BaseResponse<Void> cancelOrder(@RequestBody CancelOrderRequest request) {
        CancelOrderCommand command = CancelOrderCommand
                .builder()
                .orderCheckingId(request.getOrderCheckingId())
                .orderId(request.getOrderId())
                .build();
        gateway.send(command);
        return BaseResponse.ofSucceeded();
    }

    @PostMapping("/ship")
    public BaseResponse<Void> shipOrder(@RequestBody ShipOrderRequest request) {
        ShipOrderCommand command = ShipOrderCommand
                .builder()
                .orderCheckingId(request.getOrderCheckingId())
                .orderId(request.getOrderId())
                .build();
        gateway.send(command);
        return BaseResponse.ofSucceeded();
    }

    @PostMapping("/return")
    public BaseResponse<Void> returnOrder(@RequestBody ReturnOrderRequest request) {
        ReturnOrderCommand command = ReturnOrderCommand
                .builder()
                .orderCheckingId(request.getOrderCheckingId())
                .orderId(request.getOrderId())
                .build();
        gateway.send(command);
        return BaseResponse.ofSucceeded();
    }

    @PostMapping("/success")
    public BaseResponse<Void> successOrder(@RequestBody SuccessOrderRequest request) {
        SuccessOrderCommand command = SuccessOrderCommand
                .builder()
                .orderCheckingId(request.getOrderCheckingId())
                .orderId(request.getOrderId())
                .build();
        gateway.send(command);
        return BaseResponse.ofSucceeded();
    }


}
