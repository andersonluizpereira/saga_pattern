package com.pereira.payment.payment.application.ports.out;

import com.pereira.payment.payment.application.core.domain.Sale;
import com.pereira.payment.payment.application.core.domain.enums.SaleEvent;

public interface SendToKafkaOutputPort {

    void send(Sale sale, SaleEvent event);

}
