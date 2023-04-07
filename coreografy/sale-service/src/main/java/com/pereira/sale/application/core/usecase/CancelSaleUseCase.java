package com.pereira.sale.application.core.usecase;

import com.pereira.sale.application.core.domain.Sale;
import com.pereira.sale.application.core.domain.enums.SaleStatus;
import com.pereira.sale.application.ports.in.CancelSaleInputPort;
import com.pereira.sale.application.ports.in.FindSaleByIdInputPort;
import com.pereira.sale.application.ports.out.SaveSaleOutPutPort;

public class CancelSaleUseCase implements CancelSaleInputPort {

    private final FindSaleByIdInputPort findSaleByIdInputPort;
    private final SaveSaleOutPutPort saveSaleOutPutPort;

    public CancelSaleUseCase(FindSaleByIdInputPort findSaleByIdInputPort, SaveSaleOutPutPort saveSaleOutPutPort) {
        this.findSaleByIdInputPort = findSaleByIdInputPort;
        this.saveSaleOutPutPort = saveSaleOutPutPort;
    }


    @Override
    public void cancel(Sale sale) {
        var saleResponse = findSaleByIdInputPort.find(sale.getId());
        saleResponse.setStatus(SaleStatus.CANCELED);
        saveSaleOutPutPort.save(saleResponse);
    }
}
