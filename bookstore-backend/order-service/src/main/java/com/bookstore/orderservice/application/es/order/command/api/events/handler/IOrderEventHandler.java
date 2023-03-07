package com.bookstore.orderservice.application.es.order.command.api.events.handler;

import com.bookstore.orderservice.application.es.order.command.api.events.*;

public interface IOrderEventHandler {

    public void on(CreateOrderEvent event);
    public void on(ConfirmOrderEvent event);
    public void on(CancelOrderEvent event);
    public void on(ShipOrderEvent event);
    public void on(ReturnOrderEvent event);
    public void on(SuccessOrderEvent event);
    public void on(DeleteOrderEvent event);
}
