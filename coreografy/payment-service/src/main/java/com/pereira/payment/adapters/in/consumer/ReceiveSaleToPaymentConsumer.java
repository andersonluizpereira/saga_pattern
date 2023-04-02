package com.pereira.payment.adapters.in.consumer;

import com.pereira.payment.adapters.out.message.SaleMessage;
import com.pereira.payment.application.core.domain.enums.SaleEvent;
import com.pereira.payment.application.ports.in.SalePaymentInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ReceiveSaleToPaymentConsumer {

    @Autowired
    private SalePaymentInputPort salePaymentInputPort;

    @KafkaListener(topics = "tp-saga-sale", groupId = "payment")
    public void receive(SaleMessage saleMessage) {
        if(SaleEvent.UPDATED_INVENTORY.equals(saleMessage.getEvent())){
            log.info("Inicio pagamento");
            salePaymentInputPort.payment(saleMessage.getSale());
            log.info("Fim pagamento");
        }
    }
}
