package com.pereira.inventory.application.ports.out;

import com.pereira.inventory.application.core.domain.Inventory;

public interface UpdateInventoryOutPutPort {
    void update(Inventory inventory);
}
