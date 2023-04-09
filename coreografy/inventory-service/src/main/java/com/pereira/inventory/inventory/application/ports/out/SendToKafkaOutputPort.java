package com.pereira.inventory.inventory.application.ports.out;

import com.pereira.inventory.inventory.application.core.domain.Sale;
import com.pereira.inventory.inventory.application.core.domain.enums.SaleEvent;

public interface SendToKafkaOutputPort {

    void send(Sale sale, SaleEvent event);

}
