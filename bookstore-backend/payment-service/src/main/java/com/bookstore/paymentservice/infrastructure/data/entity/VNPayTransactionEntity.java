package com.bookstore.paymentservice.infrastructure.data.entity;

import com.bookstore.paymentservice.common.infrastructure.repo.model.BaseModel;
import lombok.Getter;
import lombok.Setter;
import org.checkerframework.checker.units.qual.C;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;


@Getter
@Setter
@Table(name = "vnp_transactions")
@Entity
public class VNPayTransactionEntity extends BaseModel {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "vnp_transaction_id", updatable = false, nullable = false)
    private String vnpTransactionId;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id")
    private PaymentEntity payment;

    @Column(name = "vnp_response_code")
    private String vnpResponseCode;
    @Column(name = "vnp_response_message")
    private String vnpResponseMessage;
    @Column(name = "vnp_transaction_no")
    private String vnpTransactionNo;

    @Column(name = "vnp_order_info")
    private String vnpTransactionInfo;

    @Column(name = "vnp_amount")
    private BigDecimal vnpAmount;

    @Column(name = "vnp_bank_code")
    private String vnpBankCode;
}
