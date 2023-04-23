package com.pereira.inventory.adapters.in.consumer;

import com.pereira.inventory.adapters.out.message.SaleMessage;
import com.pereira.inventory.application.core.domain.enums.SaleEvent;
import com.pereira.inventory.application.ports.in.CreditInventoryInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToCreditInventoryConsumer {

    @Autowired
    private CreditInventoryInputPort creditInventoryInputPort;

    @KafkaListener(topics = "tp-saga-inventory", groupId = "inventory-credit")
    public void receive(SaleMessage saleMessage) {
        if(SaleEvent.EXECUTE_ROLLBACK.equals(saleMessage.getEvent())) {
            log.info("Início da devolução da mercadoria.");
            creditInventoryInputPort.credit(saleMessage.getSale());
            log.info("Fim da devolução da mercadoria");
        }
    }


}
