package com.bookstore.orderservice.application.es.cart_item.command.api.controller;


import com.bookstore.orderservice.common.application.response.dto.BaseResponse;
import com.bookstore.orderservice.application.es.cart_item.command.api.commands.RemoveCartItemCommand;
import com.bookstore.orderservice.application.es.cart_item.command.model.dto.RemoveCartItemRequest;
import lombok.NoArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@NoArgsConstructor
@RequestMapping("/cart-item")
public class CartItemCommandController {

    @Autowired
    private CommandGateway gateway;

//    @PostMapping
//    public BaseResponse<Void> createCartItem(
//            @RequestBody AddProductToCartRequest request) {
//        AddCartItemCommand command = new AddCartItemCommand(UUID.randomUUID().toString(),
//                request.getCartId(),
//                request.getQuantity(),
//                request.getProductId(),
//                request.getProductName(),
//                request.getImages(),
//                request.getProductId(),
//                request.getProductPrice()
//        );
//        gateway.sendAndWait(command);
//        return BaseResponse.ofSucceeded();
//    }

    @DeleteMapping
    public BaseResponse<Void> deleteItem(@RequestBody RemoveCartItemRequest request){
        RemoveCartItemCommand command = new RemoveCartItemCommand(UUID.randomUUID().toString(),
                request.getCartItemId());
        gateway.sendAndWait(command);
        return BaseResponse.ofSucceeded();
    }
}
