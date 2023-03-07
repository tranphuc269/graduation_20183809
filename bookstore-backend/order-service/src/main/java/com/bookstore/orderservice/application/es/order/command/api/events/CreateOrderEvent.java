package com.bookstore.orderservice.application.es.order.command.api.events;


import com.bookstore.orderservice.application.es.order.command.write_model.dto.CreateOrderShippingAddressRequest;
import com.bookstore.orderservice.common.infrastructure.axon.BaseEvent;
import com.bookstore.orderservice.utils.OrderStatus;
import com.bookstore.orderservice.utils.PaymentMethod;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderEvent extends BaseEvent<String> {
    private PaymentMethod paymentMethod;
    private OrderStatus orderStatus;

    private String userId;

    private String cartId;

    CreateOrderShippingAddressRequest shippingAddress;

    public CreateOrderEvent(String orderCheckingId,
                            PaymentMethod paymentMethod,
                            String cartId,
                            String userId,
                            CreateOrderShippingAddressRequest shippingAddress) {
        super(orderCheckingId);
        this.orderStatus = OrderStatus.CREATED;
        this.paymentMethod = paymentMethod;
        this.cartId = cartId;
        this.userId = userId;
        this.shippingAddress = shippingAddress;
    }

    @Override
    public String toString() {
        return "CreateOrderEvent{" +
                "id=" + super.id +
                ", paymentMethod=" + paymentMethod +
                ", orderStatus=" + orderStatus +
                ", cartId='" + cartId + '\'' +
                '}';
    }
}
