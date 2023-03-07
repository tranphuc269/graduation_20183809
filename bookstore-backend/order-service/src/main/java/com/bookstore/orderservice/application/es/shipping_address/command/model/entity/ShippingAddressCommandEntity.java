package com.bookstore.orderservice.application.es.shipping_address.command.model.entity;


import com.bookstore.orderservice.common.infrastructure.repo.model.BaseModel;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order_addresses")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShippingAddressCommandEntity extends BaseModel {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "address_id", updatable = false, nullable = false)
    private String addressId;
    @Column(name = "city", updatable = false, nullable = false)
    private String city;

    @Column(name = "detail", updatable = false, nullable = false)
    private String detail;

    @Column(name = "district", updatable = false, nullable = false)
    private String district;

    @Column(name = "order_id", updatable = false, nullable = false)
    private String orderId;

    @Column(name = "phone_number", updatable = false, nullable = false)
    private String phoneNumber;

    @Column(name = "province", updatable = false, nullable = false)
    private String province;

    @Column(name = "user_id", updatable = false, nullable = false)
    private String userId;

    @Column(name = "user_name", updatable = false, nullable = false)
    private String userName;


}
