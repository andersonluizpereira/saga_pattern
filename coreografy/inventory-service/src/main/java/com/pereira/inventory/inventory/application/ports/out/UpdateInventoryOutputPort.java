package com.pereira.inventory.inventory.application.ports.out;

import com.pereira.inventory.inventory.application.core.domain.Inventory;

public interface UpdateInventoryOutputPort {

    void update(Inventory inventory);

}
