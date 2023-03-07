package com.bookstore.catalogservice.application.es.author.command.api.events;

import com.bookstore.catalogservice.application.es.author.data.AuthorRepository;
import com.bookstore.catalogservice.application.es.author.data.model.AuthorModel;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class AuthorEventHandlerImpl implements IAuthorEvent {

    @Autowired
    private AuthorRepository repository;

    @Override
    @EventHandler
    public void on(CreateAuthorEvent event) {
        AuthorModel author = new AuthorModel();
        author.setName(event.getAuthorName());
        author.setImages(event.getImages());
        author.setDescription(event.getDescription());
        author.setCreateTime(new Date());
        author.setUpdateTime(new Date());
        author.setStatus(1);
        repository.save(author);
    }

    @Override
    @EventHandler
    public void on(UpdateAuthorEvent event) {
        Optional<AuthorModel> author = repository.findById(event.getAuthorId());
//        if(author.isEmpty()){
//            throw new RuntimeException("Not found by author id");
//        }
        author.get().setName(event.getAuthorName());
        author.get().setImages(event.getImages());
        author.get().setDescription(event.getDescription());
        author.get().setUpdateTime(new Date());
        author.get().setStatus(event.getStatus());
        repository.save(author.get());

    }

    @Override
    @EventHandler
    public void on(DeleteAuthorEvent event) {
        Optional<AuthorModel> author = repository.findById(event.getAuthorId());
//        if(author.isEmpty()){
//            throw new RuntimeException("Not found by author id");
//        }
        author.get().setStatus(0);
        repository.save(author.get());
    }

    @Override
    public void on(EnableAuthorEvent event) {
        Optional<AuthorModel> author = repository.findById(event.getAuthorId());
//        if(author.isEmpty()){
//            throw new RuntimeException("Not found by author id");
//        }
        author.get().setStatus(1);
        repository.save(author.get());
    }
}
