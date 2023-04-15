package com.pereira.inventory.inventory.config.usecase;

import com.pereira.inventory.inventory.adapters.out.SendToKafkaAdapter;
import com.pereira.inventory.inventory.adapters.out.UpdateInventoryAdapter;
import com.pereira.inventory.inventory.application.core.usecase.CreditInventoryUseCase;
import com.pereira.inventory.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditInventoryConfig {

    @Bean
    public CreditInventoryUseCase creditInventoryUseCase(
            FindInventoryByProductIdUseCase findInventoryByProductIdUseCase,
            UpdateInventoryAdapter updateInventoryAdapter
    ) {
        return new CreditInventoryUseCase(findInventoryByProductIdUseCase, updateInventoryAdapter);
    }

}
