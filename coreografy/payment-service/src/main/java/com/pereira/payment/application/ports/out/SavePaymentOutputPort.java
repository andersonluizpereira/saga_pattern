package com.pereira.payment.application.ports.out;

import com.pereira.payment.application.core.domain.Payment;

public interface SavePaymentOutputPort {
    void save(Payment payment);
}
