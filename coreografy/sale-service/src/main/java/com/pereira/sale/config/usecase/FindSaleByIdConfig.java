package com.pereira.sale.config.usecase;

import com.pereira.sale.adapters.out.FindSaleByIdAdapter;
import com.pereira.sale.application.core.usecase.FindSaleByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindSaleByIdConfig {
    @Bean
    public FindSaleByIdUseCase findSaleByIdUseCase(FindSaleByIdAdapter findSaleByIdAdapter) {
        return new FindSaleByIdUseCase(findSaleByIdAdapter);
    }
}
