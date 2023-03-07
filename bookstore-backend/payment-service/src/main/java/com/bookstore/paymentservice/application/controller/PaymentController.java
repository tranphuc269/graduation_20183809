package com.bookstore.paymentservice.application.controller;

import com.bookstore.paymentservice.application.dto.request.PaymentRequest;
import com.bookstore.paymentservice.application.dto.request.PaymentCODRequest;
import com.bookstore.paymentservice.application.dto.request.PaymentVNPayRequest;
import com.bookstore.paymentservice.application.dto.response.PaymentResponse;
import com.bookstore.paymentservice.application.gateway.PaymentGateway;
import com.bookstore.paymentservice.common.application.response.dto.BaseResponse;
import com.bookstore.paymentservice.utils.VNPAYUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/payments")

public class PaymentController {


    private final PaymentGateway<PaymentResponse, PaymentRequest> paymentGateway;

    @Autowired
    public PaymentController(PaymentGateway<PaymentResponse, PaymentRequest> paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    @PostMapping("/cod-pay")
    public ResponseEntity<PaymentResponse> processCOD(
            @RequestBody PaymentCODRequest paymentRequest) throws UnsupportedEncodingException {
        return ResponseEntity.ok(paymentGateway.makePayment(paymentRequest));
    }

    @PostMapping("/vnpay-pay")
    public ResponseEntity<BaseResponse<PaymentResponse>> processVNPAY(
            @RequestBody PaymentVNPayRequest paymentRequest, HttpServletRequest request) throws UnsupportedEncodingException {
        paymentRequest.setIpAddress(VNPAYUtils.getIpAddress(request));
        return ResponseEntity.ok(BaseResponse.ofSucceeded(paymentGateway.makePayment(paymentRequest)));
    }

    @PostMapping("/bank-transfer-pay")
    public ResponseEntity<PaymentResponse> processBankTransfer(
            @RequestBody PaymentVNPayRequest paymentRequest) throws UnsupportedEncodingException {
        return ResponseEntity.ok(paymentGateway.makePayment(paymentRequest));
    }
}