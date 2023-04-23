package com.pereira.inventory.application.ports.in;

import com.pereira.inventory.application.core.domain.Inventory;

public interface FindInventoryByProductIdInputPort {

    Inventory find(Integer productId);

}
