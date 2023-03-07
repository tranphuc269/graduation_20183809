package com.bookstore.catalogservice.application.es.attribute.command.api.events.attributevalue;

import com.bookstore.catalogservice.application.es.attribute.command.write_data.entity.AttributeValueModel;
import com.bookstore.catalogservice.application.es.attribute.repository.AttributeValueRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component

public class AttributeValueEventHandler {
    @Autowired
    private AttributeValueRepository repository;

    @EventHandler
    public void on(CreateAttributeValueEvent event) {
        AttributeValueModel model = new AttributeValueModel();
        model.setAttributeId(event.getAttributeId());
        model.setValue(event.getValue());
        model.setCreateTime(new Date());
        model.setUpdateTime(new Date());
        model.setProductId(event.getProductId());
        model.setStatus(1);
        model.setValue(event.getValue());
        repository.save(model);
    }
}
