package com.pereira.orchestrator.config.usecase;

import com.pereira.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.pereira.orchestrator.application.core.usecase.CreatedSaleUsecase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreatedSaleConfig {
    @Bean
    public CreatedSaleUsecase createdSaleUsecase(SendSaleToTopicAdapter sendSaleToTopicAdapter) {
        return new CreatedSaleUsecase(sendSaleToTopicAdapter);
    }
}
