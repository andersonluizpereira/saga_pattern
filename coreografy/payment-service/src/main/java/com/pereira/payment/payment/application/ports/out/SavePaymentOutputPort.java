package com.pereira.payment.payment.application.ports.out;

import com.pereira.payment.payment.application.core.domain.Payment;

public interface SavePaymentOutputPort {

    void save(Payment payment);

}
