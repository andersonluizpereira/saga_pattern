package com.pereira.inventory.adapters.in.consumer;

import com.pereira.inventory.adapters.out.message.SaleMessage;
import com.pereira.inventory.application.ports.in.DebitInventoryInputPort;
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
        log.info("Init Received sale message: ");
        debitInventoryInputPort.debit(saleMessage.getSale());
        log.info("Finish Received sale message: ");
    }
}
