package com.bookstore.catalogservice.application.es.attribute.command.write_data.entity;


//import com.bookstore.catalogservice.common.infrastructure.repo.model.BaseModel;
import com.bookstore.catalogservice.common.infrastructure.repo.model.BaseModel;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Table(name = "attributes")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttributeModel extends BaseModel {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "attribute_id", updatable = false, nullable = false)
    private String attributeId;

    private String name;
}
