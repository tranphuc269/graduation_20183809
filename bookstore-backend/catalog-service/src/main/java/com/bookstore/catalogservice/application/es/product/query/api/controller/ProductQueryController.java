package com.bookstore.catalogservice.application.es.product.query.api.controller;


import com.bookstore.catalogservice.application.es.product.query.api.queries.AddProductToCartQuery;
import com.bookstore.catalogservice.application.es.product.query.api.queries.GetDetailProductQuery;
import com.bookstore.catalogservice.application.es.product.query.api.queries.ProductQueryAll;
import com.bookstore.catalogservice.application.es.product.query.api.queries.ProductsFilterQuery;
import com.bookstore.catalogservice.application.es.product.query.api.services.IProductService;
import com.bookstore.catalogservice.application.es.product.query.read_model.query_request.CheckProductQuantity;
import com.bookstore.catalogservice.application.es.product.query.read_model.query_request.ProductAddToCartRequest;
import com.bookstore.catalogservice.application.es.product.query.read_model.query_request.ProductFilterRequest;
import com.bookstore.catalogservice.application.es.product.query.read_model.response.CheckProductQuantityResponse;
import com.bookstore.catalogservice.application.es.product.query.read_model.response.ProductDetailResponse;
import com.bookstore.catalogservice.application.es.product.query.read_model.response.ProductResponse;
import com.bookstore.catalogservice.common.application.response.dto.BaseResponse;
import com.bookstore.catalogservice.common.domain.exception.BusinessError;
import com.bookstore.catalogservice.common.utils.CommonUtilityMethods;
import lombok.NoArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping("/product")
public class ProductQueryController {


    @Autowired
    public ProductQueryController(QueryGateway gateway, IProductService service) {
        System.out.println("Product controller inject");
        this.gateway = gateway;
        this.service = service;
    }

    private QueryGateway gateway;
    private IProductService service;

    @GetMapping("/{productId}")
    public ResponseEntity<BaseResponse<Object>> getDetailProduct(@PathVariable String productId) {
        try {
            GetDetailProductQuery query = GetDetailProductQuery
                    .builder()
                    .productId(productId)
                    .build();

            return ResponseEntity.ok(BaseResponse
                    .ofSucceeded(
                            gateway
                                    .query(query,
                                            ResponseTypes.instanceOf(ProductDetailResponse.class))
                                    .join()));
        } catch (Exception ignored) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(BaseResponse
                    .ofFailed(new BusinessError(404,
                            ignored.getMessage(), HttpStatus.NOT_FOUND)));
        }
    }

    @PostMapping("/filter")
    public ResponseEntity<Object> getFilterProducts(@RequestBody ProductFilterRequest request) {
        ProductsFilterQuery query = ProductsFilterQuery
                .builder()
                .categoryId(request.getCategoryId())
                .authorId(request.getAuthorId())
                .sort(request.getSort())
                .limit(request.getLimit())
                .offset(request.getOffset())
                .build();
        return ResponseEntity.ok(BaseResponse
                .ofSucceeded(
                        gateway
                                .query(query,
                                        ResponseTypes.multipleInstancesOf(ProductResponse.class))
                                .join()));
    }

    @GetMapping("")
    public ResponseEntity<Object> getAllProducts() {
        ProductQueryAll noneFilter = ProductQueryAll
                .builder()
                .session("")
                .build();
        return ResponseEntity.ok(BaseResponse
                .ofSucceeded(
                        gateway
                                .query(noneFilter,
                                        ResponseTypes.multipleInstancesOf(ProductResponse.class))
                                .join()));
    }

    @PostMapping("/add-to-cart")
    public ResponseEntity<Object> addProductToCart(@RequestBody ProductAddToCartRequest request) {
        System.out.println("Create cart");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userIdFromToken = CommonUtilityMethods.getUserIdFromToken(authentication);
        AddProductToCartQuery query = AddProductToCartQuery
                .builder()
                .userId(userIdFromToken)
                .productId(request.getProductId())
                .build();
        return ResponseEntity.ok(BaseResponse
                .ofSucceeded(
                        gateway
                                .query(query,
                                        ResponseTypes.instanceOf(String.class))
                                .join()));
    }

    @PostMapping("/check-product-quantity")
    public ResponseEntity<List<CheckProductQuantityResponse>> checkProductQuantityResponse(@RequestBody List<CheckProductQuantity> data) {
        return ResponseEntity.ok(service.checkProductQuantity(data));
    }

}
