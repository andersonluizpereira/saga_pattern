package com.pereira.inventory.inventory.application.core.usecase;

import com.pereira.inventory.inventory.application.core.domain.Inventory;
import com.pereira.inventory.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.pereira.inventory.inventory.application.ports.out.FindInventoryByProductIdOutputPort;

public class FindInventoryByProductIdUseCase implements FindInventoryByProductIdInputPort {

    private final FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort;

    public FindInventoryByProductIdUseCase(
            FindInventoryByProductIdOutputPort findInventoryByProductIdOutputPort
    ) {
        this.findInventoryByProductIdOutputPort = findInventoryByProductIdOutputPort;
    }

    @Override
    public Inventory find(Integer productId) {
        return findInventoryByProductIdOutputPort.find(productId)
                .orElseThrow(() -> new RuntimeException("Estoque não encontrado para este produto!"));
    }

}
