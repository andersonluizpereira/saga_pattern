package com.pereira.orchestrator.config.usecase;

import com.pereira.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.pereira.orchestrator.application.core.usecase.IventoryFailureUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryFailureConfig {
    @Bean
    public IventoryFailureUseCase iventoryFailureUseCase(SendSaleToTopicAdapter sendSaleToTopicAdapter) {
        return new IventoryFailureUseCase(sendSaleToTopicAdapter);
    }
}