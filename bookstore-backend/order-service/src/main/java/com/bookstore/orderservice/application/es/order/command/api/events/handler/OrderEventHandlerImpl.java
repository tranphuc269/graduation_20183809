package com.bookstore.orderservice.application.es.order.command.api.events.handler;

import com.bookstore.orderservice.application.client.model.VNPayResponseClient;
import com.bookstore.orderservice.application.client.service.IWebClient;
import com.bookstore.orderservice.application.es.order.command.write_model.dto.CreateOrderShippingAddressRequest;
import com.bookstore.orderservice.common.infrastructure.kafka.notification.KafkaNotificationDeviceRequest;
import com.bookstore.orderservice.common.infrastructure.kafka.notification.KafkaNotificationEmailRequest;
import com.bookstore.orderservice.application.es.order.command.api.events.*;
import com.bookstore.orderservice.application.es.order.command.write_model.OrderCommandRepository;
import com.bookstore.orderservice.application.es.cart_item.command.api.commands.RemoveAllCartItemCommand;
import com.bookstore.orderservice.application.es.cart_item.query.api.queries.GetListCartItemQuery;
import com.bookstore.orderservice.application.es.cart_item.query.model.dto.CartItemResponse;
import com.bookstore.orderservice.application.es.order.command.write_model.entity.OrderCommandEntity;
import com.bookstore.orderservice.application.es.order_item.command.api.commands.CreateOrderItemCommand;
import com.bookstore.orderservice.application.es.order_item.command.model.entity.OrderItemCommandEntity;
import com.bookstore.orderservice.application.es.shipping_address.command.api.commands.CreateShippingAddressCommand;
import com.bookstore.orderservice.common.utils.notification.NotificationDestination;
import com.bookstore.orderservice.common.utils.notification.NotificationSourceType;
import com.bookstore.orderservice.domain.service.notification.NotificationService;
import com.bookstore.orderservice.utils.OrderStatus;
import com.bookstore.orderservice.utils.PaymentStatus;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Component
public class OrderEventHandlerImpl implements IOrderEventHandler {
    @Autowired
    private OrderCommandRepository repository;

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private QueryGateway queryGateway;

    @Autowired
    private NotificationService notificationService;


    @Autowired
    private IWebClient webClient;
    @Override
    @EventHandler
    public void on(CreateOrderEvent event) {
        System.out.println("EventHandler : CreateOrderEvent");
        OrderCommandEntity entity = OrderCommandEntity
                .builder()
                .orderCheckingId(event.getId())
                .userId(event.getUserId())
                .orderStatus(OrderStatus.CREATED.name())
                .paymentMethod(event.getPaymentMethod().name())
                .paymentStatus(PaymentStatus.PROCESSING.name())
                .build();
//        VNPayResponseClient responseClient = webClient.createPayment();
        entity.setStatus(1);
        entity.setCreateTime(new Date());
        entity.setUpdateTime(new Date());
        OrderCommandEntity save = repository.save(entity);
        createOrderItem(event.getCartId(), save.getOrderId());
        createShippingAddress(save.getOrderId(), event.getShippingAddress());

        new Thread(() -> {
            notificationService.send(KafkaNotificationEmailRequest
                    .builder()
                    .title("Bạn đã đặt thành công đơn hàng : " + save.getOrderId())
                    .userId(save.getUserId())
                    .destination(NotificationDestination.EMAIL)
                    .build());
        }).start();

        new Thread(() -> {
            notificationService.send(KafkaNotificationDeviceRequest
                    .builder()
                    .title("Bạn đã đặt thành công đơn hàng : " + save.getOrderId())
                    .userId(save.getUserId())
                    .sourceId(save.getOrderId())
                    .destination(NotificationDestination.DEVICE)
                    .sourceType(NotificationSourceType.ORDER)
                    .build());
        }).start();


    }


    private void createOrderItem(String cartId, String orderId) {
        List<CartItemResponse> cartItemResponses = queryGateway.query(GetListCartItemQuery
                        .builder()
                        .cartId(cartId)
                        .build(), ResponseTypes.multipleInstancesOf(CartItemResponse.class))
                .join();
        commandGateway.send(new RemoveAllCartItemCommand(UUID.randomUUID().toString(), cartId));
        List<OrderItemCommandEntity> entities = cartItemResponses
                .stream().map(cart -> OrderItemCommandEntity
                        .builder()
                        .productId(cart.getProductId())
                        .orderId(orderId)
                        .productName(cart.getProductName())
                        .productPrice(cart.getProductPrice())
                        .productShortContent(cart.getProductShortContent())
                        .images(cart.getImages().toString())
                        .quantity(cart.getQuantity())
                        .build())
                .collect(Collectors.toList());
        commandGateway
                .send(new CreateOrderItemCommand(UUID.randomUUID().toString(), entities));
    }

    private void createShippingAddress(String orderId,
                                       CreateOrderShippingAddressRequest shippingAddressRequest) {
        CreateShippingAddressCommand command = new CreateShippingAddressCommand(
                UUID.randomUUID().toString(),
                shippingAddressRequest.getCity(),
                shippingAddressRequest.getDetail(),
                shippingAddressRequest.getDistrict(),
                orderId,
                shippingAddressRequest.getPhoneNumber(),
                shippingAddressRequest.getProvince(),
                shippingAddressRequest.getUserName(),
                ""
        );
        commandGateway.send(command);
    }

    @EventHandler
    @Override
    public void on(ConfirmOrderEvent event) {
        System.out.println("EventHandler : ConfirmOrderEvent : " + event.getId());
        Optional<OrderCommandEntity> entityOptional = repository.getOrderCommandEntityByOrderCheckingId(event.getId());
        if (entityOptional.isEmpty()) {
            throw new RuntimeException();
        }
        entityOptional.get().setOrderStatus(OrderStatus.CONFIRMED.name());
        entityOptional.get().setUpdateTime(new Date());
        repository.save(entityOptional.get());
        notificationService.send(KafkaNotificationDeviceRequest
                .builder()
                .title("Đơn hàng của bạn đã được đóng gói, mã đơn hàng : " + entityOptional.get().getOrderId())
                .userId(entityOptional.get().getUserId())
                .sourceId(entityOptional.get().getOrderId()).sourceType(NotificationSourceType.ORDER)
                .build());
    }

    @EventHandler
    @Override
    public void on(CancelOrderEvent event) {
        System.out.println("EventHandler : CancelOrderEvent");
        Optional<OrderCommandEntity> entityOptional = repository.findById(event.getOrderId());
        if (entityOptional.isEmpty()) {
            throw new RuntimeException();
        }
        entityOptional.get().setOrderStatus(OrderStatus.CANCEL.name());
        entityOptional.get().setUpdateTime(new Date());
        repository.save(entityOptional.get());
        notificationService.send(KafkaNotificationDeviceRequest
                .builder()
                .title("Đơn hàng của bạn đã bị huỷ, mã đơn hàng : " + entityOptional.get().getOrderId())
                .userId(entityOptional.get().getUserId())
                .sourceId(entityOptional.get().getOrderId()).sourceType(NotificationSourceType.ORDER)
                .build());
    }

    @EventHandler
    @Override
    public void on(ShipOrderEvent event) {
        System.out.println("EventHandler : ShipOrderEvent");
        Optional<OrderCommandEntity> entityOptional = repository.findById(event.getOrderId());
        if (entityOptional.isEmpty()) {
            throw new RuntimeException();
        }
        entityOptional.get().setOrderStatus(OrderStatus.SHIPPED.name());
        entityOptional.get().setUpdateTime(new Date());
        repository.save(entityOptional.get());
        notificationService.send(KafkaNotificationDeviceRequest
                .builder()
                .title("Đơn hàng của bạn đã được giao cho bên vận chuyển, mã đơn hàng : " + entityOptional.get().getOrderId())
                .userId(entityOptional.get().getUserId())
                .destination(NotificationDestination.EMAIL)
                .sourceId(entityOptional.get().getOrderId()).sourceType(NotificationSourceType.ORDER)
                .build());
    }

    @EventHandler
    @Override
    public void on(ReturnOrderEvent event) {
        System.out.println("EventHandler : ReturnOrderEvent");
        Optional<OrderCommandEntity> entityOptional = repository.findById(event.getOrderId());
        if (entityOptional.isEmpty()) {
            throw new RuntimeException();
        }
        entityOptional.get().setOrderStatus(OrderStatus.RETURNED.name());
        entityOptional.get().setUpdateTime(new Date());
        repository.save(entityOptional.get());
        notificationService.send(KafkaNotificationDeviceRequest
                .builder()
                .title("Đơn hàng của bạn đã được hoàn lại, mã đơn hàng : " + entityOptional.get().getOrderId())
                .userId(entityOptional.get().getUserId())
                .destination(NotificationDestination.EMAIL)
                .sourceId(entityOptional.get().getOrderId()).sourceType(NotificationSourceType.ORDER)
                .build());
    }

    @EventHandler
    @Override
    public void on(SuccessOrderEvent event) {
        System.out.println("EventHandler : SuccessOrderEvent");
        Optional<OrderCommandEntity> entityOptional = repository.findById(event.getOrderId());
        if (entityOptional.isEmpty()) {
            throw new RuntimeException();
        }
        entityOptional.get().setOrderStatus(OrderStatus.SUCCESSED.name());
        entityOptional.get().setUpdateTime(new Date());
        repository.save(entityOptional.get());
        notificationService.send(KafkaNotificationDeviceRequest
                .builder()
                .title("Đơn hàng của bạn đã được giao hoàn tất, mã đơn hàng : " + entityOptional.get().getOrderId())
                .userId(entityOptional.get().getUserId())
                .destination(NotificationDestination.EMAIL)
                .sourceId(entityOptional.get().getOrderId()).sourceType(NotificationSourceType.ORDER)
                .build());
    }

    @Override
    @EventHandler
    public void on(DeleteOrderEvent event) {
        System.out.println("Delete");
        repository.deleteByOrderCheckingId(event.getOrderCheckingId());
    }
}
