package com.bookstore.catalogservice.application.es.attribute.repository;


import com.bookstore.catalogservice.application.es.attribute.command.write_data.entity.AttributeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttributeRepository extends JpaRepository<AttributeModel, String> {

    @Query( "select a from AttributeModel a where a.attributeId in :attributeIds" )
    List<AttributeModel> findAllByAttributeIds(List<String> attributeIds);
}
