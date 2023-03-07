package com.bookstore.orderservice.application.es.shipping_address.command.api.events.handler;

import com.bookstore.orderservice.application.es.shipping_address.command.api.events.CreateShippingAddressEvent;

public interface IShippingAddressHandler {

    public void on(CreateShippingAddressEvent event);

}
