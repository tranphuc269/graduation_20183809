package com.bookstore.catalogservice.application.es.product.command.api.events;

import com.bookstore.catalogservice.application.es.product.command.write_model.ProductCommandRepository;
import com.bookstore.catalogservice.application.es.product.command.write_model.entity.ProductCommandEntity;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class ProductEventHandlerImpl implements IProductEventHandler {

    @Autowired
    private ProductCommandRepository repository;

    @Override
    @EventHandler
    public void on(CreateProductEvent event) {
        ProductCommandEntity product = ProductCommandEntity
                .builder()
                .availableItemCount(event.getAvailableItemCount())
                .name(event.getName())
                .images(event.getImages())
                .shortContent(event.getShortContent())
                .description(event.getDescription())
                .price(event.getPrice())
                .quantitySold(0)
                .categoryId(event.getCategoryId())
                .authorId(event.getAuthorId())
                .build();
        product.setStatus(1);
        product.setCreateTime(new Date());
        product.setUpdateTime(new Date());
        repository.save(product);
    }

    @Override
    @EventHandler
    public void on(UpdateProductEvent event) {
        Optional<ProductCommandEntity> productCommand =
                repository.findById(event.getProductId());
//        if(productCommand.isEmpty()){
//            throw new ExceptionCommon(new BusinessError(404,
//                    "Not found product", HttpStatus.NOT_FOUND));
//        }
        if(productCommand.isEmpty()){
            return;
        }
        productCommand.get().setPrice(event.getPrice());
        productCommand.get().setStatus(1);
        productCommand.get().setName(event.getName());
        productCommand.get().setDescription(event.getDescription());
        productCommand.get().setShortContent(event.getShortContent());
        productCommand.get().setAvailableItemCount(event.getAvailableItemCount());
        productCommand.get().setImages(event.getImages());
        productCommand.get().setAuthorId(event.getAuthorId());
        productCommand.get().setCategoryId(event.getCategoryId());
        productCommand.get().setUpdateTime(new Date());
        repository.save(productCommand.get());
    }

    @Override
    @EventHandler
    public void on(DeleteProductEvent event) {
        Optional<ProductCommandEntity> productCommand =
                repository.findById(event.getProductId());
//        if(productCommand.isEmpty()){
//            throw new ExceptionCommon(new BusinessError(404,
//                    "Not found product", HttpStatus.NOT_FOUND));
//        }
        if(productCommand.isEmpty()){
            return;
        }
        productCommand.get().setUpdateTime(new Date());
        productCommand.get().setStatus(0);
        repository.save(productCommand.get());
    }
    @EventHandler
    @Override
    public void on(EnableProductEvent event) {
        Optional<ProductCommandEntity> productCommand =
                repository.findById(event.getProductId());
//        if(productCommand.isEmpty()){
//            throw new ExceptionCommon(new BusinessError(404,
//                    "Not found product", HttpStatus.NOT_FOUND));
//        }
        if(productCommand.isEmpty()){
            return;
        }
        productCommand.get().setUpdateTime(new Date());
        productCommand.get().setStatus(1);
        repository.save(productCommand.get());
    }
    @EventHandler
    @Override
    public void on(SellProductEvent event) {
        ProductCommandEntity productCommand =
                repository.findById(event.getProductId()).get();
        productCommand
                .setQuantitySold(productCommand.getQuantitySold()
                        + event.getQuantity());
        productCommand.setAvailableItemCount(productCommand.getAvailableItemCount() - event.getQuantity());
        repository.save(productCommand);
    }
}
