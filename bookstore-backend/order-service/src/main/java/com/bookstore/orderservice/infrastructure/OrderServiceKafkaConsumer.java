package com.bookstore.orderservice.infrastructure;

import com.bookstore.orderservice.common.infrastructure.kafka.product_order.KafkaSendProductCreateCartItem;
import com.bookstore.orderservice.common.utils.KafkaTopicUtils;
import com.bookstore.orderservice.application.es.cart.command.api.commands.CreateCartCommand;
import com.bookstore.orderservice.application.es.cart.query.api.queries.GetCartByUserIdQuery;
import com.bookstore.orderservice.application.es.cart.query.model.entity.CartQueryEntity;
import com.bookstore.orderservice.application.es.cart_item.command.api.commands.AddCartItemCommand;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
public class OrderServiceKafkaConsumer {

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private QueryGateway queryGateway;

    @KafkaListener(topics = KafkaTopicUtils.TOPIC_ADD_TO_CART)
    public void addProductToCart(String kafkaMessage) {
        log.info("Kafka Message : " + kafkaMessage);

        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();

        try {
            map = mapper.readValue(kafkaMessage, new TypeReference<>() {
            });
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        KafkaSendProductCreateCartItem request = KafkaSendProductCreateCartItem.builder()
                .userId((String) map.get("userId"))
                .quantity(Integer.parseInt(map.get("quantity").toString()))
                .productId((String) map.get("productId"))
                .productName((String) map.get("productName"))
                .images((String) map.get("images"))
                .productShortDescription(map.get("productShortDescription").toString())
                .productPrice(Double.parseDouble(map.get("productPrice").toString()))
                .build();
        CartQueryEntity entity = queryGateway.query(
                        GetCartByUserIdQuery.builder().userId(request.getUserId()).build(),
                        ResponseTypes.instanceOf(CartQueryEntity.class))
                .join();
        AddCartItemCommand command = new AddCartItemCommand(UUID.randomUUID().toString(),
                entity.getCartId(),
                request.getQuantity(),
                request.getProductName(),
                request.getProductShortDescription(),
                request.getImages(),
                request.getProductId(),
                request.getProductPrice()
        );
        commandGateway.sendAndWait(command);
    }



    @KafkaListener(topics = KafkaTopicUtils.TOPIC_CREATE_CART_FROM_USER)
    public void createCart(String kafkaMessage) {
        log.info("Kafka Message KafkaTopicUtils.TOPIC_CREATE_CART_FROM_USER : " + kafkaMessage);
        Map<Object, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        CreateCartCommand command = new CreateCartCommand(UUID.randomUUID().toString(),
                kafkaMessage);
        commandGateway.send(command);
    }
}
