package com.bookstore.paymentservice.domain.service.impl;

import com.bookstore.paymentservice.application.dto.request.PaymentCODRequest;
import com.bookstore.paymentservice.application.dto.response.PaymentCODResponse;
import com.bookstore.paymentservice.application.dto.response.PaymentResponse;
import com.bookstore.paymentservice.domain.service.PaymentService;
import com.bookstore.paymentservice.utils.VNPAYUtils;
import org.springframework.stereotype.Component;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class PaymentCODService implements
        PaymentService<PaymentCODRequest, PaymentCODResponse> {

    @Override
    public PaymentCODResponse pay(PaymentCODRequest request) {
        return new PaymentCODResponse();
    }
}
