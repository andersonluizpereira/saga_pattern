package com.pereira.sale.adapters.in.controller.mapper;

import com.pereira.sale.adapters.in.controller.request.SaleRequest;
import com.pereira.sale.application.core.domain.Sale;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SaleRequestMapper {
    Sale toSale(SaleRequest saleRequest);
}
