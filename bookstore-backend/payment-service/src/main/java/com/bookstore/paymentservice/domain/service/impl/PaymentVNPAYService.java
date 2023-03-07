package com.bookstore.paymentservice.domain.service.impl;

import com.bookstore.paymentservice.application.dto.request.PaymentVNPayRequest;
import com.bookstore.paymentservice.application.dto.response.PaymentVNPayResponse;
import com.bookstore.paymentservice.domain.service.PaymentService;
import com.bookstore.paymentservice.infrastructure.data.repository.PaymentRepository;
import com.bookstore.paymentservice.infrastructure.data.repository.VNPayTransactionRepository;
import com.bookstore.paymentservice.utils.VNPAYUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class PaymentVNPAYService implements
        PaymentService<PaymentVNPayRequest, PaymentVNPayResponse> {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private VNPayTransactionRepository vnPayTransactionRepository;

    @Override
    public PaymentVNPayResponse pay(PaymentVNPayRequest request) throws UnsupportedEncodingException {
        // To do payment logic with provider 1 ...
//        return new PaymentCODResponse();
        int amount = request.getAmount() * 100;
        Map<String, String> vnp_params = new HashMap<>();
        vnp_params.put("vnp_Version", VNPAYUtils.vnp_Version);
        vnp_params.put("vnp_Command", VNPAYUtils.vnp_Command);
        vnp_params.put("vnp_TmnCode", VNPAYUtils.vnp_TmnCode);
        vnp_params.put("vnp_Amount", String.valueOf(amount));

        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String vnp_CreateDate = time.format(formatter);
        vnp_params.put("vnp_CreateDate", vnp_CreateDate);

        vnp_params.put("vnp_CurrCode", VNPAYUtils.vnp_CurrCode);
        vnp_params.put("vnp_IpAddr", request.getIpAddress());
        vnp_params.put("vnp_Locale", VNPAYUtils.vnp_Locale);
        vnp_params.put("vnp_OrderInfo", request.getDescription());
        vnp_params.put("vnp_OrderType", VNPAYUtils.vnp_OrderType);
        vnp_params.put("vnp_ReturnUrl", VNPAYUtils.vnp_ReturnUrl);
        vnp_params.put("vnp_TxnRef", VNPAYUtils.getOTP(8));

        List fieldName = new ArrayList(vnp_params.keySet());
        Collections.sort(fieldName);

        StringBuilder hashData = new StringBuilder();
        StringBuilder query = new StringBuilder();

        Iterator iterator = fieldName.iterator();
        while (iterator.hasNext()) {
            String name = (String) iterator.next();
            String value = vnp_params.get(name);
            if ((value != null) && (value.length() > 0)) {

                hashData.append(name);
                hashData.append("=");
                hashData.append(URLEncoder.encode(value, StandardCharsets.US_ASCII.toString()));

                query.append(URLEncoder.encode(name, StandardCharsets.US_ASCII.toString()));
                query.append("=");
                query.append(URLEncoder.encode(value, StandardCharsets.US_ASCII));

                if (iterator.hasNext()) {
                    query.append("&");
                    hashData.append("&");
                }
            }
        }
        String queryUrl = query.toString();
        String vnp_SecureHash = VNPAYUtils.hmacSHA512(VNPAYUtils.vnp_HashSecret, hashData.toString());
        queryUrl += "&vnp_SecureHash=" + vnp_SecureHash;
        String paymentUrl = VNPAYUtils.vnp_PayUrl + "?" + queryUrl;

        return PaymentVNPayResponse
                .builder()
                .status("00")
                .message("success")
                .url(paymentUrl)
                .build();
    }
}
