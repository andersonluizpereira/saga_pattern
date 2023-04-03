package com.pereira.sale.application.ports.out;

import com.pereira.sale.application.core.domain.Sale;

import java.util.Optional;

public interface FindSaleByIdOutputPort {
    Optional<Sale> find(Integer id);
}
