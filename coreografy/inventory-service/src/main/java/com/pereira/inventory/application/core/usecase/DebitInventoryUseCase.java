package com.pereira.inventory.application.core.usecase;

import com.pereira.inventory.application.core.domain.Sale;
import com.pereira.inventory.application.core.domain.enums.SaleEvent;
import com.pereira.inventory.application.ports.in.DebitInventoryInputPort;
import com.pereira.inventory.application.ports.in.FindInventoryByProductIdInputPort;
import com.pereira.inventory.application.ports.out.SendToKafkaOutPutPort;
import com.pereira.inventory.application.ports.out.UpdateInventoryOutPutPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DebitInventoryUseCase implements DebitInventoryInputPort {
    private final FindInventoryByProductIdInputPort findInventoryByProductIdInputPort;
    private final UpdateInventoryOutPutPort updateInventoryOutPutPort;
    private final SendToKafkaOutPutPort sendToKafkaOutPutPort;

    public DebitInventoryUseCase(FindInventoryByProductIdInputPort findInventoryByProductIdInputPort, UpdateInventoryOutPutPort updateInventoryOutPutPort, SendToKafkaOutPutPort sendToKafkaOutPutPort) {
        this.findInventoryByProductIdInputPort = findInventoryByProductIdInputPort;
        this.updateInventoryOutPutPort = updateInventoryOutPutPort;
        this.sendToKafkaOutPutPort = sendToKafkaOutPutPort;
    }

    @Override
    public void debit(Sale sale) {
        try {
            var inventory = findInventoryByProductIdInputPort.find(sale.getProductId());
            if (inventory.getQuantity() < sale.getQuantity()) {
                throw new RuntimeException("Not enough inventory");
            }
            inventory.debit(sale.getQuantity());
            updateInventoryOutPutPort.update(inventory);
            sendToKafkaOutPutPort.send(sale, SaleEvent.UPDATED_INVENTORY);
        } catch (Exception e) {
            log.error("Error on debit inventory", e.getMessage());
            sendToKafkaOutPutPort.send(sale, SaleEvent.ROLLBACK_INVENTORY);
        }
    }
}
