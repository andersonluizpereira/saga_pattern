package com.pereira.payment.application.ports.in;

import com.pereira.payment.application.core.domain.Sale;

public interface SalePaymentInputPort {
    void payment(Sale sale);
}
