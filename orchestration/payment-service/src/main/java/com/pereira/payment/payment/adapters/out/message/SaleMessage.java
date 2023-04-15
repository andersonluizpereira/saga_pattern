package com.pereira.payment.payment.adapters.out.message;

import com.pereira.payment.payment.application.core.domain.Sale;
import com.pereira.payment.payment.application.core.domain.enums.SaleEvent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleMessage {

    private Sale sale;

    private SaleEvent event;

}
