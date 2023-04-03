package com.pereira.inventory.application.ports.in;

import com.pereira.inventory.application.core.domain.Sale;

public interface CreditInventoryInputPort {
    void credit(Sale sale);
}
