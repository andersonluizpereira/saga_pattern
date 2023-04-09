package com.pereira.inventory.inventory.application.ports.in;

import com.pereira.inventory.inventory.application.core.domain.Sale;

public interface DebitInventoryInputPort {

    void debit(Sale sale);

}
