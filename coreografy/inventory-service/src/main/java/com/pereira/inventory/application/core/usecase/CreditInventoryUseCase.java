package com.pereira.inventory.application.core.usecase;

import com.pereira.inventory.application.core.domain.Sale;
import com.pereira.inventory.application.core.domain.enums.SaleEvent;
import com.pereira.inventory.application.ports.in.CreditInventoryInputPort;
import com.pereira.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.pereira.inventory.application.ports.out.SendToKafkaOutPutPort;
import com.pereira.inventory.application.ports.out.UpdateInventoryOutPutPort;

public class CreditInventoryUseCase implements CreditInventoryInputPort {

    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;
    private final UpdateInventoryOutPutPort updateInventoryOutPutPort;

    private final SendToKafkaOutPutPort sendToKafkaOutPutPort;

    public CreditInventoryUseCase(FindInventoryByProductIdInputPort findInventoryByProductIdInputPort, UpdateInventoryOutPutPort updateInventoryOutPutPort, SendToKafkaOutPutPort sendToKafkaOutPutPort) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutPutPort = updateInventoryOutPutPort;
        this.sendToKafkaOutPutPort = sendToKafkaOutPutPort;
    }

    @Override
    public void credit(Sale sale) {
        var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
        inventory.credit(sale.getQuantity());
        updateInventoryOutPutPort.update(inventory);
        sendToKafkaOutPutPort.send(sale, SaleEvent.ROLLBACK_INVENTORY);
    }
}
