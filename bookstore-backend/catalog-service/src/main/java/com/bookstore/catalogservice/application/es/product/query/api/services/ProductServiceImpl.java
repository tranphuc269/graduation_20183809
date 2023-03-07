package com.bookstore.catalogservice.application.es.product.query.api.services;
import com.bookstore.catalogservice.application.es.product.command.write_model.ProductCommandRepository;
import com.bookstore.catalogservice.application.es.product.command.write_model.entity.ProductCommandEntity;
import com.bookstore.catalogservice.application.es.product.query.read_model.ProductQueryRepository;
import com.bookstore.catalogservice.application.es.product.query.read_model.entity.ProductQueryEntity;
import com.bookstore.catalogservice.application.es.product.query.read_model.query_request.CheckProductQuantity;
import com.bookstore.catalogservice.application.es.product.query.read_model.response.CheckProductQuantityResponse;
import com.google.common.collect.Iterables;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements IProductService {

    @Autowired
    ProductQueryRepository repository;

    @Autowired
    ProductCommandRepository commandRepository;

    @Autowired
    CommandGateway commandGateway;

    @Override
    public List<CheckProductQuantityResponse> checkProductQuantity(List<CheckProductQuantity> request) {
        List<ProductQueryEntity> products =
                repository.findByProductIdIn(request.stream().map(CheckProductQuantity::getProductId).collect(Collectors.toList()));
        List<CheckProductQuantityResponse> response = new ArrayList<>();
        products.forEach(productQueryEntity -> {
            CheckProductQuantity req = Iterables.tryFind(request, checkProductQuantity ->
                    productQueryEntity.getProductId().equals(checkProductQuantity.getProductId())).orNull();
            if (req != null) {
                response.add(CheckProductQuantityResponse
                        .builder()
                        .productId(productQueryEntity.getProductId())
                        .isEnough(req.getQuantity() < productQueryEntity.getAvailableItemCount())
                        .build());
            }
        });

        boolean allObjectsAreEnough = response.stream()
                .allMatch(CheckProductQuantityResponse::isEnough);

        if (allObjectsAreEnough) {
            request.forEach(checkProductQuantity -> {
                ProductCommandEntity productCommand =
                        commandRepository.findById(checkProductQuantity.getProductId()).get();
                productCommand
                        .setQuantitySold(productCommand.getQuantitySold()
                                + checkProductQuantity.getQuantity());
                productCommand.setAvailableItemCount(productCommand.getAvailableItemCount() - checkProductQuantity.getQuantity());
                commandRepository.save(productCommand);
            });
        }
        return response;
    }
}
