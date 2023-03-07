package com.bookstore.catalogservice.application.es.cqrs;

public abstract class QueryBase<T> {
    private T identity;

    public QueryBase(T identity){
        this.identity = identity;
    }
}
