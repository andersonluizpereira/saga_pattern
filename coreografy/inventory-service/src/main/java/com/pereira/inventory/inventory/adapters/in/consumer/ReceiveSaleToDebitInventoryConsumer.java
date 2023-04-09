package com.pereira.inventory.inventory.adapters.in.consumer;

import com.pereira.inventory.inventory.adapters.out.message.SaleMessage;
import com.pereira.inventory.inventory.application.core.domain.enums.SaleEvent;
import com.pereira.inventory.inventory.application.ports.in.DebitInventoryInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToDebitInventoryConsumer {

    @Autowired
    private DebitInventoryInputPort debitInventoryInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "inventory-debit")
    public void receive(SaleMessage saleMessage) {
        if(SaleEvent.CREATED_SALE.equals(saleMessage.getEvent())) {
            log.info("Início da separação de mercadoria.");
            debitInventoryInputPort.debit(saleMessage.getSale());
            log.info("Fim da separação de mercadoria.");
        }
    }

}
