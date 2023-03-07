package com.bookstore.orderservice.application.es.order.query.api.projection;


import com.bookstore.orderservice.application.client.model.VNPayResponseClient;
import com.bookstore.orderservice.application.client.model.request.CreateVNPayRequest;
import com.bookstore.orderservice.application.client.service.IWebClient;
import com.bookstore.orderservice.application.es.order.query.api.queries.OrderDetailRequest;
import com.bookstore.orderservice.application.es.order.query.api.queries.OrderListHistoryRequest;
import com.bookstore.orderservice.application.es.order.query.api.queries.OrderHistoryRequestCheckingQuery;
import com.bookstore.orderservice.application.es.order.query.api.queries.OrderPaymentUrlRequest;
import com.bookstore.orderservice.application.es.order.query.model.OrderQueryRepository;
import com.bookstore.orderservice.application.es.order.query.model.dto.OrderDetailResponse;
import com.bookstore.orderservice.application.es.order.query.model.dto.OrderListResponse;
import com.bookstore.orderservice.application.es.order.query.model.entity.OrderQueryEntity;
import com.bookstore.orderservice.application.es.order_item.query.model.OrderItemQueryRepository;
import com.bookstore.orderservice.application.es.order_item.query.model.dto.OrderItemResponse;
import com.bookstore.orderservice.application.es.order_item.query.model.entity.OrderItemQueryEntity;
import com.bookstore.orderservice.application.es.shipping_address.query.model.ShippingAddressQueryRepository;
import com.bookstore.orderservice.application.es.shipping_address.query.model.dto.ShippingAddressResponse;
import com.bookstore.orderservice.application.es.shipping_address.query.model.entity.ShippingAddressQueryEntity;
import com.bookstore.orderservice.common.utils.CommonUtilityMethods;
import org.aspectj.weaver.ast.Or;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.axonframework.queryhandling.QueryGateway;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Order;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderProjection {

    @Autowired
    private EventStore eventStore;

    @Autowired
    private QueryGateway queryGateway;

    @Autowired
    private OrderQueryRepository repository;

    @Autowired
    private OrderItemQueryRepository orderItemQueryRepository;

    @Autowired
    private ShippingAddressQueryRepository shippingAddressRepository;

    @Autowired
    private IWebClient webClient;

    @QueryHandler
    public List<Object> handle(OrderHistoryRequestCheckingQuery query) {
        return eventStore.readEvents(query.getOrderCheckingId())
                .asStream()
                .map(Message::getPayload)
                .collect(Collectors.toList());
    }


    @QueryHandler
    public List<OrderListResponse> handle(OrderListHistoryRequest query) {
        List<OrderListResponse> responses = new ArrayList<>();
        List<OrderQueryEntity> entities = repository.findAllByUserId(query.getUserId());
        entities.forEach(orderQueryEntity -> {
            BigDecimal totalPrice = orderItemQueryRepository.totalPrice(orderQueryEntity.getOrderId());
            if (totalPrice == null) {
                totalPrice = BigDecimal.valueOf(1000000);
            }
            OrderListResponse response = OrderListResponse
                    .builder()
                    .orderId(orderQueryEntity.getOrderId())
                    .orderCheckingId(orderQueryEntity.getOrderCheckingId())
                    .orderStatus(orderQueryEntity.getOrderStatus())
                    .paymentMethod(orderQueryEntity.getPaymentMethod())
                    .paymentStatus(orderQueryEntity.getPaymentStatus())
                    .createdAt(orderQueryEntity.getCreateTime())
                    .totalItem(orderItemQueryRepository.countByOrderId(orderQueryEntity.getOrderId()))
                    .totalPrice(totalPrice)
                    .build();
            responses.add(response);
        });
        return responses;
    }

    @QueryHandler
    public OrderDetailResponse handle(OrderDetailRequest query) {
        OrderDetailResponse response = new OrderDetailResponse();
        OrderQueryEntity entity = repository.findById(query.getOrderId()).get();
        List<Object> trackingStatus = eventStore.readEvents(entity.getOrderCheckingId())
                .asStream()
                .map(Message::getPayload)
                .collect(Collectors.toList());
        response.setTrackingOrderStatuses(trackingStatus);
        response.setOrderId(entity.getOrderId());
        response.setOrderCheckingId(entity.getOrderCheckingId());
        response.setUpdatedAt(entity.getUpdateTime());
        response.setOrderStatus(entity.getOrderStatus());
        response.setPaymentMethod(entity.getPaymentMethod());
        response.setPaymentStatus(entity.getPaymentStatus());
        response.setPaymentStatus(entity.getPaymentStatus());
        List<OrderItemQueryEntity> orderItemQueryEntities =
                orderItemQueryRepository.findAllByOrderId(query.getOrderId());
        ShippingAddressQueryEntity shippingAddress =
                shippingAddressRepository.findByOrderId(query.getOrderId()).get();
        List<OrderItemResponse> orderItemResponses =
                orderItemQueryEntities.stream().map(orderItemEntity -> OrderItemResponse
                        .builder()
                        .orderItemId(orderItemEntity.getOrderItemId())
                        .productId(orderItemEntity.getProductId())
                        .productPrice(orderItemEntity.getProductPrice())
                        .productName(orderItemEntity.getProductName())
                        .productShortContent(orderItemEntity.getProductShortContent())
                        .images(orderItemEntity.getListImages())
                        .quantity(orderItemEntity.getQuantity())
                        .build()).collect(Collectors.toList());
        response.setOrderItems(orderItemResponses);

        response.setShippingAddress(ShippingAddressResponse
                .builder()
                .addressId(shippingAddress.getAddressId())
                .city(shippingAddress.getCity())
                .detail(shippingAddress.getDetail())
                .district(shippingAddress.getDistrict())
                .phoneNumber(shippingAddress.getPhoneNumber())
                .province(shippingAddress.getProvince())
                .userName(shippingAddress.getUserName())
                .build());
        return response;
    }

    @QueryHandler
    public String handle(OrderPaymentUrlRequest query) {
        OrderQueryEntity entity = repository.findByOrderCheckingId(query.getOrderCheckingId());
        List<OrderItemQueryEntity> orderItemQueryEntities =
                orderItemQueryRepository.findAllByOrderId(entity.getOrderId());
        double totalValue =orderItemQueryEntities.stream().mapToDouble(OrderItemQueryEntity::getProductPrice).sum();
        VNPayResponseClient client = webClient.createPayment(CreateVNPayRequest
                        .builder()
                        .amount(totalValue)
                        .description("Thanh toán đơn hàng " + entity.getOrderId())
                        .build(),
                query.getToken());
        return client.getData().getUrl();
    }
}
