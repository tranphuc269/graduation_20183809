package com.bookstore.orderservice.application.es.order.command.api.aggregate;


import com.bookstore.orderservice.application.es.order.command.api.commands.*;
import com.bookstore.orderservice.application.es.order.command.api.events.*;
import com.bookstore.orderservice.utils.OrderStatus;
import com.bookstore.orderservice.utils.PaymentMethod;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.io.Serializable;
import java.util.UUID;

@Aggregate
public class OrderCommandAggregate implements Serializable {

    private static final long serialVersionUID = 1L;
    @AggregateIdentifier
    private String orderCheckingId;

    private String orderId;

    private OrderStatus orderStatus;

    private PaymentMethod paymentMethod;

    protected OrderCommandAggregate() {
    }


    // create order
    @CommandHandler
    public OrderCommandAggregate(CreateOrderCommand command) {
        AggregateLifecycle.apply(new CreateOrderEvent(
                command.getOrderCheckingId(),
                command.getPaymentMethod(),
                command.getCartId(),
                command.getUserId(), command.getShippingAddress()));
    }

    @EventSourcingHandler
    public void on(CreateOrderEvent event) {
        this.orderCheckingId = event.getId();
        this.orderStatus = OrderStatus.CREATED;
        this.paymentMethod = event.getPaymentMethod();
    }

    // confirm
    @CommandHandler
    public void on(ConfirmOrderCommand command) {
        ConfirmOrderEvent event = new ConfirmOrderEvent(command.getOrderCheckingId());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ConfirmOrderEvent event) {
        this.orderStatus = OrderStatus.CONFIRMED;
    }

    // cancel order
    @CommandHandler
    public void on(CancelOrderCommand command) {
        CancelOrderEvent event = new CancelOrderEvent(command.getOrderCheckingId(),
                command.getOrderId());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CancelOrderEvent event) {
//        this.orderCheckingId = event.getOrderCheckingId();
        this.orderId = event.getOrderId();
        this.orderStatus = OrderStatus.CANCEL;
    }

    // ship order
    @CommandHandler
    public void on(ShipOrderCommand command) {
        ShipOrderEvent event = new ShipOrderEvent(command.getOrderCheckingId(),
                command.getOrderId());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ShipOrderEvent event) {
//        this.orderCheckingId = event.getOrderCheckingId();
        this.orderId = event.getOrderId();
        this.orderStatus = OrderStatus.SHIPPED;
    }

    // success order
    @CommandHandler
    public void on(SuccessOrderCommand command) {
        SuccessOrderEvent event = new SuccessOrderEvent(
                command.getOrderCheckingId(),
                command.getOrderId());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(SuccessOrderEvent event) {
//        this.orderCheckingId = event.getOrderCheckingId();
        this.orderId = event.getOrderId();
        this.orderStatus = OrderStatus.SUCCESSED;
    }

    // return order
    @CommandHandler
    public void on(ReturnOrderCommand command) {
        ReturnOrderEvent event = new ReturnOrderEvent(command.getOrderCheckingId(),
                command.getOrderId());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ReturnOrderEvent event) {
//        this.orderCheckingId = event.getOrderCheckingId();
        this.orderId = event.getOrderId();
        this.orderStatus = OrderStatus.SUCCESSED;
    }

    // delete order for saga
    @CommandHandler
    public void on(DeleteOrderCommand command){
        DeleteOrderEvent event = DeleteOrderEvent
                .builder()
                .id(command.getId())
                .orderCheckingId(command.getOrderCheckingId())
                .build();
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(DeleteOrderEvent event){
        this.orderId = event.getId();
        this.orderCheckingId = event.getOrderCheckingId();
    }
}
