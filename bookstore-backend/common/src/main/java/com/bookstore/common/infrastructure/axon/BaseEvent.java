package com.bookstore.common.infrastructure.axon;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
public class BaseEvent<T> {

    public final T id;

    private Date createdDate;

    public BaseEvent(T id) {
        this.id = id;
        this.createdDate = new Date();
    }
}