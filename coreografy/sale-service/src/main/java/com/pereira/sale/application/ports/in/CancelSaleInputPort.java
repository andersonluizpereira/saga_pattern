package com.pereira.sale.application.ports.in;

import com.pereira.sale.application.core.domain.Sale;

public interface CancelSaleInputPort {
    void cancel(Sale sale);
}
