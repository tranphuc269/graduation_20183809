package com.bookstore.catalogservice.application.es.product.command.api.events;

public interface IProductEventHandler {
    public void on(CreateProductEvent event);
    public void on(UpdateProductEvent event);
    public void on(DeleteProductEvent event);

    public void on(EnableProductEvent event);

    public void on(SellProductEvent event);
}
