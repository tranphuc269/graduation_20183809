package com.bookstore.orderservice.application.es.order.command.api.events;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DeleteOrderEvent {
    String id;
    String orderCheckingId;

}
