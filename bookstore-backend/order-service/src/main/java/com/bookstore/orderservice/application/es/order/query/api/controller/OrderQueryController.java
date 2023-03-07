package com.bookstore.orderservice.application.es.order.query.api.controller;

import com.bookstore.orderservice.application.es.order.query.api.queries.OrderDetailRequest;
import com.bookstore.orderservice.application.es.order.query.api.queries.OrderHistoryRequestCheckingQuery;
import com.bookstore.orderservice.application.es.order.query.api.queries.OrderListHistoryRequest;
import com.bookstore.orderservice.application.es.order.query.api.queries.OrderPaymentUrlRequest;
import com.bookstore.orderservice.common.application.response.dto.BaseResponse;
import com.bookstore.orderservice.common.utils.CommonUtilityMethods;
import lombok.NoArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@NoArgsConstructor
@RequestMapping("/order")
public class OrderQueryController {


    @Autowired
    private QueryGateway gateway;

    @GetMapping("/{orderCheckingId}")
    public Object checkingOrderHistoryStatus(@PathVariable String orderCheckingId) {
        OrderHistoryRequestCheckingQuery query = OrderHistoryRequestCheckingQuery
                .builder()
                .orderCheckingId(orderCheckingId)
                .build();
        return gateway.query(query,
                        ResponseTypes.multipleInstancesOf(Object.class))
                .join();
    }

    @GetMapping("/histories")
    public ResponseEntity<BaseResponse<Object>> getOrderListHistory() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userIdFromToken = CommonUtilityMethods.getUserIdFromToken(authentication);
        OrderListHistoryRequest request = OrderListHistoryRequest
                .builder()
                .userId(userIdFromToken)
                .build();
        return ResponseEntity.ok(BaseResponse.ofSucceeded(gateway.query(request,
                        ResponseTypes.multipleInstancesOf(Object.class))
                .join()));
    }

    @GetMapping("/detail/{orderId}")
    public ResponseEntity<BaseResponse<Object>> getDetailHistory(@PathVariable String orderId) {
        System.out.println("orderId : " + orderId);
        OrderDetailRequest request = OrderDetailRequest
                .builder()
                .orderId(orderId)
                .build();
        System.out.println("request : " + request);
        return ResponseEntity.ok(BaseResponse.ofSucceeded(gateway.query(request,
                        ResponseTypes.instanceOf(Object.class))
                .join()));
    }

    @GetMapping("/vnpay-url/{orderCheckingId}")
    public ResponseEntity<BaseResponse<Object>> getPaymentUrl(@PathVariable String orderCheckingId, @RequestHeader HttpHeaders headers) {
        OrderPaymentUrlRequest request = OrderPaymentUrlRequest
                .builder()
                .orderCheckingId(orderCheckingId)
                .token(CommonUtilityMethods.getTokenFromRequestHeader(headers))
                .build();
        return ResponseEntity.ok(BaseResponse.ofSucceeded(gateway.query(request,
                        ResponseTypes.instanceOf(Object.class))
                .join()));
    }
}
