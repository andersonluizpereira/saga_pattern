package com.pereira.payment.application.ports.out;

import com.pereira.payment.application.core.domain.Sale;
import com.pereira.payment.application.core.domain.enums.SaleEvent;

public interface SendValidatedPaymentOutputPort {
    void send(Sale sale, SaleEvent event);
}
