package com.bookstore.orderservice.application.es.order.saga;


import com.bookstore.orderservice.application.es.order.command.api.commands.DeleteOrderCommand;
import com.bookstore.orderservice.application.es.order.command.api.events.CreateOrderEvent;
import com.bookstore.orderservice.application.es.order.command.api.events.DeleteOrderEvent;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.modelling.saga.EndSaga;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.SagaLifecycle;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.spring.stereotype.Saga;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

@Saga
public class OrderSaga {

    @Autowired
    private transient CommandGateway commandGateway;

    @Autowired
    private transient QueryGateway queryGateway;

    @StartSaga
    @SagaEventHandler(associationProperty = "id")
    public void handle(CreateOrderEvent event) {
        System.out.println("Start saga with id : " + event.getId() + " width cart id : " + event.getCartId());

        try {
//            throw new Exception();
            SagaLifecycle.associateWith("id", event.getId());

        } catch (Exception e) {
            rollBackCreateOrder(event.getId());
        }
    }

    private void rollBackCreateOrder(String orderCheckingId) {
        DeleteOrderCommand orderCommand = DeleteOrderCommand.builder()
                .id(UUID.randomUUID().toString())
                .orderCheckingId(orderCheckingId).build();
        commandGateway.send(orderCommand);
    }

    @SagaEventHandler(associationProperty = "id")
    @EndSaga
    public void handle(DeleteOrderEvent event) {
        System.out.println("End order saga Id : {} " +
                event.getOrderCheckingId());
        SagaLifecycle.end();
    }
}
