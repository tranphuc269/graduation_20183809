package com.bookstore.orderservice.application.es.shipping_address.command.api.aggregate;


import com.bookstore.orderservice.application.es.shipping_address.command.api.commands.CreateShippingAddressCommand;
import com.bookstore.orderservice.application.es.shipping_address.command.api.events.CreateShippingAddressEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class ShippingAddressAggregate {

    @AggregateIdentifier
    private String id;

    private String city;

    private String detail;

    private String district;

    private String orderId;

    private String phoneNumber;

    private String province;

    private String userId;

    private String userName;

    public ShippingAddressAggregate(){}

    @CommandHandler
    public ShippingAddressAggregate(CreateShippingAddressCommand command){
        CreateShippingAddressEvent event = new CreateShippingAddressEvent(command.id,
                command.getCity(),
                command.getDetail(),
                command.getDistrict(),
                command.getOrderId(),
                command.getPhoneNumber(),
                command.getProvince(),
                command.getUserId(),
                command.getUserName());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(CreateShippingAddressEvent event){
        this.id = event.id;
        this.city = event.getCity();
        this.detail = event.getDetail();
        this.district = event.getDistrict();
        this.orderId = event.getOrderId();
        this.phoneNumber = event.getPhoneNumber();
        this.province = event.getProvince();
        this.userName = event.getUserName();
    }

}
