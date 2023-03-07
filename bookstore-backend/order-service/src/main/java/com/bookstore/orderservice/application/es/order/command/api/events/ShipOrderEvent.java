package com.bookstore.orderservice.application.es.order.command.api.events;


import com.bookstore.orderservice.common.infrastructure.axon.BaseEvent;
import com.bookstore.orderservice.utils.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShipOrderEvent extends BaseEvent<String> {
    private String orderId;
    private OrderStatus status;

    public ShipOrderEvent(String orderCheckingId, String orderId) {
        super(orderCheckingId);
        this.orderId = orderId;
        this.status = OrderStatus.SHIPPED;
    }
}
