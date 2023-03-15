package com.pereira.sale.application.ports.out;

import com.pereira.sale.application.core.domain.Sale;

public interface SaveSaleOutPutPort {
    Sale save(Sale sale);
}
