package com.pereira.sale.application.core.usecase;

import com.pereira.sale.application.core.domain.Sale;
import com.pereira.sale.application.core.domain.enums.SaleEvent;
import com.pereira.sale.application.core.domain.enums.SaleStatus;
import com.pereira.sale.application.ports.out.SaveSaleOutPutPort;
import com.pereira.sale.application.ports.out.SendCreatedSaleOutPutPort;

public class CreateSaleUseCase {

    private final SaveSaleOutPutPort saveSaleOutPutPort;
    private final SendCreatedSaleOutPutPort sendCreatedSaleOutPutPort;

    public CreateSaleUseCase(SaveSaleOutPutPort saveSaleOutPutPort, SendCreatedSaleOutPutPort sendCreatedSaleOutPutPort) {
        this.saveSaleOutPutPort = saveSaleOutPutPort;
        this.sendCreatedSaleOutPutPort = sendCreatedSaleOutPutPort;
    }

    public void create(Sale sale) {
        sale.setStatus(SaleStatus.PENDING);
        var saleResponse = saveSaleOutPutPort.save(sale);
        sendCreatedSaleOutPutPort.send(saleResponse, SaleEvent.CREATED_SALE);
    }
}
