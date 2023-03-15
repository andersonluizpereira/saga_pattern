package com.pereira.sale.application.ports.out;

import com.pereira.sale.application.core.domain.Sale;
import com.pereira.sale.application.core.domain.enums.SaleEvent;

public interface SendCreatedSaleOutPutPort {
    void send(Sale sale, SaleEvent event);
}
