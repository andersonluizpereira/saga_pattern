package com.pereira.orchestrator.adapters.in.consumer;

import com.pereira.orchestrator.adapters.out.message.SaleMessage;
import com.pereira.orchestrator.application.ports.in.WorkflowInputPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ReceiveSaleToProcessConsumer {

    @Autowired
    private List<WorkflowInputPort> workflows;

    @KafkaListener(topics = "tp-saga-orchestrator", groupId = "orchestrator")
    public void receive(SaleMessage saleMessage) {
        var workflow = workflows.stream()
                .filter(w -> w.isCalledByTheEvent(saleMessage.getEvent()))
                .findFirst()
                .orElse(null);
        if (workflow != null) {
            workflow.execute(saleMessage.getSale());
        } else {
            log.error("Nenhum workflow encontrado para o evento: " + saleMessage.getEvent());
        }
    }
}
