package com.bookstore.orderservice.application.es.order.command.api.commands;


import com.bookstore.orderservice.application.es.order.command.write_model.dto.CreateOrderShippingAddressRequest;
import com.bookstore.orderservice.utils.PaymentMethod;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class CreateOrderCommand {
    private String orderCheckingId;
    private PaymentMethod paymentMethod;

    private String userId;
    private String cartId;

    private CreateOrderShippingAddressRequest shippingAddress;

}
