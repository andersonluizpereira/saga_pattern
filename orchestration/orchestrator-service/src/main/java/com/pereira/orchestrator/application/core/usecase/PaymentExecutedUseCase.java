package com.pereira.orchestrator.application.core.usecase;

import com.pereira.orchestrator.application.core.domain.Sale;
import com.pereira.orchestrator.application.core.domain.enums.SaleEvent;
import com.pereira.orchestrator.application.ports.in.WorkflowInputPort;
import com.pereira.orchestrator.application.ports.out.SendSaleToTopicOutputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaymentExecutedUseCase implements WorkflowInputPort {

    private final SendSaleToTopicOutputPort sendSaleToTopicOutputPort;

    public PaymentExecutedUseCase(
            SendSaleToTopicOutputPort sendSaleToTopicOutputPort
    ) {
        this.sendSaleToTopicOutputPort = sendSaleToTopicOutputPort;
    }


    @Override
    public void execute(Sale sale) {
        log.info("Finalizando a venda.");
        sendSaleToTopicOutputPort.send(sale, SaleEvent.FINALIZE_SALE, "tp-saga-sale");
        log.info("Finalização da venda postada na fila.");
    }

    @Override
    public boolean isCalledByTheEvent(SaleEvent saleEvent) {
        return SaleEvent.PAYMENT_EXECUTED.equals(saleEvent);
    }

}
