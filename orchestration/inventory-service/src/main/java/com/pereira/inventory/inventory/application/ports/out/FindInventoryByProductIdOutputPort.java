package com.pereira.inventory.inventory.application.ports.out;

import com.pereira.inventory.inventory.application.core.domain.Inventory;

import java.util.Optional;

public interface FindInventoryByProductIdOutputPort {

    Optional<Inventory> find(final Integer productId);

}
