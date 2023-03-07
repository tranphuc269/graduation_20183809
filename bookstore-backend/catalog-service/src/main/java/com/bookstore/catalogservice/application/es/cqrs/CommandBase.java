package com.bookstore.catalogservice.application.es.cqrs;

import lombok.Getter;

@Getter
public abstract class CommandBase<T> {
    private T identity;

    public CommandBase(T identity){
        this.identity = identity;
    }
}
