package com.pereira.payment.payment.adapters.out.repository.mapper;

import com.pereira.payment.payment.adapters.out.repository.entity.PaymentEntity;
import com.pereira.payment.payment.application.core.domain.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentEntityMapper {

    PaymentEntity toPaymentEntity(Payment payment);

}
