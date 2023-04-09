package com.pereira.sale.application.ports.out;

import com.pereira.sale.application.core.domain.Sale;

public interface SaveSaleOutputPort {

    Sale save(Sale sale);

}
