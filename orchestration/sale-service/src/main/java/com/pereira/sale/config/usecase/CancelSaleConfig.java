package com.pereira.sale.config.usecase;

import com.pereira.sale.adapters.out.SaveSaleAdapter;
import com.pereira.sale.application.core.usecase.CancelSaleUseCase;
import com.pereira.sale.application.core.usecase.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CancelSaleConfig {

    @Bean
    public CancelSaleUseCase cancelSaleUseCase(
            FindSaleByIdUseCase findSaleByIdUseCase,
            SaveSaleAdapter saveSaleAdapter
    ) {
        return new CancelSaleUseCase(findSaleByIdUseCase, saveSaleAdapter);
    }

}
