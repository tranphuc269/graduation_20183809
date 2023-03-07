package com.bookstore.orderservice.application.es.order.query.model.dto;

import com.bookstore.orderservice.application.es.order_item.query.model.dto.OrderItemResponse;
import com.bookstore.orderservice.application.es.shipping_address.query.model.dto.ShippingAddressResponse;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class OrderDetailResponse {
    String orderId;
    String orderCheckingId;
    String orderStatus;
    String paymentMethod;
    String paymentStatus;
    Date updatedAt;
    List<OrderItemResponse> orderItems;
    ShippingAddressResponse shippingAddress;
    List<Object> trackingOrderStatuses;
}
