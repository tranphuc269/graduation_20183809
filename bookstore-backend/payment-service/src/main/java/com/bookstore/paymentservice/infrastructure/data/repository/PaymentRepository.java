package com.bookstore.paymentservice.infrastructure.data.repository;

import com.bookstore.paymentservice.infrastructure.data.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, String > {
}
