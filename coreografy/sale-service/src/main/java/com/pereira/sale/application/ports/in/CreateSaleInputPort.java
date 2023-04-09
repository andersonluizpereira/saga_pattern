package com.pereira.sale.application.ports.in;

import com.pereira.sale.application.core.domain.Sale;

public interface CreateSaleInputPort {

    void create(Sale sale);

}
