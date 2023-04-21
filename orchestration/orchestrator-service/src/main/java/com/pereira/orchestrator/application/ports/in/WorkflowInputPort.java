package com.pereira.orchestrator.application.ports.in;

import com.pereira.orchestrator.application.core.domain.Sale;
import com.pereira.orchestrator.application.core.domain.enums.SaleEvent;

public interface WorkflowInputPort {
    void execute(Sale sale);

    boolean isCalledByTheEvent(SaleEvent saleEvent);
}
