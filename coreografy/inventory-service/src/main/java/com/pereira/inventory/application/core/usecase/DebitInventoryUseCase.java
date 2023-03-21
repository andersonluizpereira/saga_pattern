package com.pereira.inventory.application.core.usecase;

import com.pereira.inventory.application.core.domain.Sale;
import com.pereira.inventory.application.core.domain.enums.SaleEvent;
import com.pereira.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.pereira.inventory.application.ports.out.SendUpdatedInventoryOutPutPort;
import com.pereira.inventory.application.ports.out.UpdateInventoryOutPutPort;

public class DebitInventoryUseCase {
    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;
    private final UpdateInventoryOutPutPort updateInventoryOutPutPort;
    private final SendUpdatedInventoryOutPutPort sendUpdatedInventoryOutPutPort;

    public DebitInventoryUseCase(FindInventoryByProductIdInputPort findInventoryByProductIdInputPort, UpdateInventoryOutPutPort updateInventoryOutPutPort, SendUpdatedInventoryOutPutPort sendUpdatedInventoryOutPutPort) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutPutPort = updateInventoryOutPutPort;
        this.sendUpdatedInventoryOutPutPort = sendUpdatedInventoryOutPutPort;
    }

    public void debit(Sale sale) {
        var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
        if (inventory.getQuantity() < sale.getQuantity()) {
            throw new RuntimeException("Not enough inventory");
        }
        inventory.debit(sale.getQuantity());
        updateInventoryOutPutPort.update(inventory);
        sendUpdatedInventoryOutPutPort.send(sale, SaleEvent.UPDATED_INVENTORY);
    }
}
