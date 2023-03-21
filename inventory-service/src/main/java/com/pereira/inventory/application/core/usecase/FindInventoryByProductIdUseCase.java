package com.pereira.inventory.application.core.usecase;

import com.pereira.inventory.application.core.domain.Inventory;
import com.pereira.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.pereira.inventory.application.ports.out.FindInventoryByProductIdOutPutPort;

public class FindInventoryByProductIdUseCase implements FindInventoryByProductIdInputPort {

    private final FindInventoryByProductIdOutPutPort findInventoryByProductIdOutPutPort;

    public FindInventoryByProductIdUseCase(FindInventoryByProductIdOutPutPort findInventoryByProductIdOutPutPort) {
        this.findInventoryByProductIdOutPutPort = findInventoryByProductIdOutPutPort;
    }

    @Override
    public Inventory find(Integer productId) {
        return findInventoryByProductIdOutPutPort.find(productId).orElseThrow(
                () -> new RuntimeException("Inventory not found")
        );
    }
}
