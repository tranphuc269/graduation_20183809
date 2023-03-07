package com.bookstore.paymentservice.infrastructure.data.entity;

import com.bookstore.paymentservice.common.infrastructure.repo.model.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;


@Getter
@Setter
@Table(name = "payments")
@Entity
public class PaymentEntity extends BaseModel {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "payment_id", updatable = false, nullable = false)
    private String paymentId;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "amount")
    private BigDecimal amount;
}
