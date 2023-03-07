package com.bookstore.catalogservice.application.es.author.command.api.events;

public interface IAuthorEvent {
    public void on(CreateAuthorEvent event);
    public void on(UpdateAuthorEvent event);
    public void on(DeleteAuthorEvent event);

    public void on(EnableAuthorEvent event);
}
