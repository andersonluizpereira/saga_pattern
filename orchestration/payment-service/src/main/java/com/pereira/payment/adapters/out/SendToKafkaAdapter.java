package com.pereira.payment.adapters.out;

import com.pereira.payment.adapters.out.message.SaleMessage;
import com.pereira.payment.application.core.domain.Sale;
import com.pereira.payment.application.core.domain.enums.SaleEvent;
import com.pereira.payment.application.ports.out.SendToKafkaOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendToKafkaAdapter implements SendToKafkaOutputPort {

    @Autowired
    private KafkaTemplate<String, SaleMessage> kafkaTemplate;

    @Override
    public void send(Sale sale, SaleEvent event) {
        var saleMessage = new SaleMessage(sale, event);
        kafkaTemplate.send("tp-saga-orchestrator", saleMessage);
    }

}
