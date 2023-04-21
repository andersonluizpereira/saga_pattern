package com.pereira.orchestrator.config.usecase;

import com.pereira.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.pereira.orchestrator.application.core.usecase.InventoryPreparedUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryPreparedConfig {
    @Bean
    public InventoryPreparedUseCase inventoryPreparedUseCase(SendSaleToTopicAdapter sendSaleToTopicAdapter) {
        return new InventoryPreparedUseCase(sendSaleToTopicAdapter);
    }
}