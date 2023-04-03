package com.pereira.sale.application.core.usecase;

import com.pereira.sale.application.core.domain.Sale;
import com.pereira.sale.application.core.domain.enums.SaleStatus;
import com.pereira.sale.application.ports.in.FinalizeSaleInputPort;
import com.pereira.sale.application.ports.in.FindSaleByIdInputPort;
import com.pereira.sale.application.ports.out.SaveSaleOutPutPort;

public class FinalizeSaleUseCase implements FinalizeSaleInputPort {

    private final FindSaleByIdInputPort findSaleByIdInputPort;
    private final SaveSaleOutPutPort saveSaleOutPutPort;


    public FinalizeSaleUseCase(FindSaleByIdInputPort findSaleByIdInputPort, SaveSaleOutPutPort saveSaleOutPutPort) {
        this.findSaleByIdInputPort = findSaleByIdInputPort;
        this.saveSaleOutPutPort = saveSaleOutPutPort;
    }

    @Override
    public void finalize(Sale sale) {
        var saleResponse = findSaleByIdInputPort.find(sale.getId());
        saleResponse.setStatus(SaleStatus.FINALIZED);
        saveSaleOutPutPort.save(saleResponse);
    }
}
