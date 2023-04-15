package com.pereira.inventory.inventory.application.ports.in;

import com.pereira.inventory.inventory.application.core.domain.Inventory;

public interface FindInventoryByProductIdInputPort {

    Inventory find(Integer productId);

}
