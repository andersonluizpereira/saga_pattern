package com.pereira.inventory.application.ports.in;

import com.pereira.inventory.application.core.domain.Sale;

public interface DebitInventoryInputPort {

    void debit(Sale sale);

}
