package com.pereira.inventory.application.ports.out;

import com.pereira.inventory.application.core.domain.Inventory;

import java.util.Optional;

public interface FindInventoryByProductIdOutPutPort {
    Optional<Inventory> find(Integer productId);
}
