package com.bookstore.catalogservice.application.es.product.query.read_model.entity;

import com.bookstore.catalogservice.common.infrastructure.repo.model.BaseModel;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "products")
@Builder
@AllArgsConstructor
public class ProductQueryEntity extends BaseModel {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "product_id", updatable = false, nullable = false)
    private String productId;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
    @Column(name = "short_content", columnDefinition = "TEXT")
    private String shortContent;
    private double price;

    @Column(name = "available_item_count")
    private int availableItemCount;
    @Column(name = "images", columnDefinition = "TEXT", length = 10000)
    private String images;

    @Column(name = "quantity_sold")
    private int quantitySold;

    @Column(name = "category_id")
    private String categoryId;
    @Column(name = "author_id")
    private String authorId;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProductQueryEntity that = (ProductQueryEntity) o;
        return productId != null && Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public List<String> getListImages() {
        List<String> imgs = new ArrayList<>();
        Collections.addAll(imgs,
                this.getImages()
                        .replace(']',
                                ' ')
                        .replace('[', ' ').trim().split(","));
        imgs.replaceAll(String::trim);
        return imgs;
    }
}
