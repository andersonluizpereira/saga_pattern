package com.pereira.inventory.config.usecase;

import com.pereira.inventory.adapters.out.SendToKafkaAdapter;
import com.pereira.inventory.adapters.out.UpdateInventoryAdapter;
import com.pereira.inventory.application.core.usecase.DebitInventoryUseCase;
import com.pereira.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DebitInventoryConfig {

    @Bean
    public DebitInventoryUseCase debitInventoryUseCase(
            FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
            UpdateInventoryAdapter updateInventoryAdapter,
            SendToKafkaAdapter sendToKafkaAdapter
    ) {
        return new DebitInventoryUseCase(findInventoryByProductIdUseCase, updateInventoryAdapter, sendToKafkaAdapter);
    }

}
