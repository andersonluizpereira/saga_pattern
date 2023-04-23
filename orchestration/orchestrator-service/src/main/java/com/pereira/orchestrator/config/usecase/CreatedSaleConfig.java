package com.pereira.orchestrator.config.usecase;

import com.pereira.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.pereira.orchestrator.application.core.usecase.CreatedSaleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreatedSaleConfig {

    @Bean
    public CreatedSaleUseCase createdSaleUseCase(SendSaleToTopicAdapter sendSaleToTopicAdapter) {
        return new CreatedSaleUseCase(sendSaleToTopicAdapter);
    }

}
