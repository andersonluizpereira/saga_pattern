package com.pereira.payment.adapters.out.repository;

import com.pereira.payment.adapters.out.repository.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {
}
