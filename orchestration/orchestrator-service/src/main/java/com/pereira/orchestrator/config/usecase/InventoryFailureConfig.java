package com.pereira.orchestrator.config.usecase;

import com.pereira.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.pereira.orchestrator.application.core.usecase.InventoryFailureUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InventoryFailureConfig {

    @Bean
    public InventoryFailureUseCase inventoryFailureUseCase(
            SendSaleToTopicAdapter sendSaleToTopicAdapter
    ) {
        return new InventoryFailureUseCase(sendSaleToTopicAdapter);
    }

}