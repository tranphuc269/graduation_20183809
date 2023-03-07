package com.bookstore.catalogservice.application.es.attribute.command.api.events.attribute;

import com.bookstore.catalogservice.application.es.attribute.command.write_data.entity.AttributeModel;
import com.bookstore.catalogservice.application.es.attribute.repository.AttributeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class AttributeEventHandler {
    @Autowired
    private AttributeRepository repository;


    @EventHandler
    public void on(CreateAttributeEvent event){
        AttributeModel model = new AttributeModel(event.getAttributeId(), event.getName());
        model.setCreateTime(new Date());
        model.setUpdateTime(new Date());
        model.setStatus(1);
        repository.save(model);
    }
}
