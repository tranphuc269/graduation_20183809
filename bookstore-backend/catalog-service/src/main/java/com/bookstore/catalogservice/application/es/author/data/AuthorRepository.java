package com.bookstore.catalogservice.application.es.author.data;

import com.bookstore.catalogservice.application.es.author.data.model.AuthorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorModel, String> {

}
