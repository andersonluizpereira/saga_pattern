package com.pereira.inventory.application.ports.out;

import com.pereira.inventory.application.core.domain.Sale;
import com.pereira.inventory.application.core.domain.enums.SaleEvent;

public interface SendUpdatedInventoryOutPutPort {
    void send(Sale sale, SaleEvent saleEvent);
}
