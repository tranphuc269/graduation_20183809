package com.bookstore.catalogservice.application.es.attribute.command.write_data.entity;


//import com.bookstore.catalogservice.common.infrastructure.repo.model.BaseModel;
import com.bookstore.catalogservice.common.infrastructure.repo.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "attribute_values")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AttributeValueModel extends BaseModel {
    @Id
    @GeneratedValue(generator="attribute_value-uuid")
    @GenericGenerator(name="attribute_value-uuid", strategy = "uuid")
    @Column(name = "attribute_value_id", updatable = false, nullable = false)
    private String attributeValueId;


    @Column(name = "attribute_id", updatable = false, nullable = false)
    private String attributeId;

    private String value;
    @Column(name = "product_id", updatable = false, nullable = false)
    private String productId;
}
