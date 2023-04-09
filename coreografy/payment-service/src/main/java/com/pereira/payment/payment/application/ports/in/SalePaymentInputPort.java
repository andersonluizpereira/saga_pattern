package com.pereira.payment.payment.application.ports.in;

import com.pereira.payment.payment.application.core.domain.Sale;

public interface SalePaymentInputPort {

    void payment(Sale sale);

}
