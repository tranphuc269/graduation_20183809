package com.bookstore.orderservice.application.es.cart.query.api.queries;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class GetCartQuery {
    private String cartId;
}
