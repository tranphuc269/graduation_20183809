package com.bookstore.paymentservice.infrastructure.data.repository;

import com.bookstore.paymentservice.infrastructure.data.entity.VNPayTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VNPayTransactionRepository
        extends JpaRepository<VNPayTransactionEntity, String> {
}
