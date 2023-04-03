package com.pereira.sale.config.usecase;

import com.pereira.sale.adapters.out.SaveSaleAdapter;
import com.pereira.sale.application.core.usecase.FinalizeSaleUseCase;
import com.pereira.sale.application.core.usecase.FindSaleByIdUseCase;
import com.pereira.sale.application.ports.in.FindSaleByIdInputPort;
import com.pereira.sale.application.ports.out.SaveSaleOutPutPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FinalizeSaleConfig {

    @Bean
    public FinalizeSaleUseCase finalizeSaleUseCase(
            FindSaleByIdUseCase findSaleByIdUseCase,
            SaveSaleAdapter saveSaleAdapter
            ) {
        return new FinalizeSaleUseCase(
                findSaleByIdUseCase,
                saveSaleAdapter
        );
    }
}
