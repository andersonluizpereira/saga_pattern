package com.pereira.orchestrator.application.ports.out;

import com.pereira.orchestrator.application.core.domain.Sale;
import com.pereira.orchestrator.application.core.domain.enums.SaleEvent;

public interface SendSaleToTopicOutputPort {

    void send(Sale sale, SaleEvent saleEvent, String topic);

}
