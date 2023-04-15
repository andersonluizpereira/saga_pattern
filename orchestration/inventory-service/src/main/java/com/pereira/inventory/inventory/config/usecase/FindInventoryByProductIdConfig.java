package com.pereira.inventory.inventory.config.usecase;

import com.pereira.inventory.inventory.adapters.out.FindInventoryByProductIdAdapter;
import com.pereira.inventory.inventory.application.core.usecase.FindInventoryByProductIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindInventoryByProductIdConfig {

    @Bean
    public FindInventoryByProductIdUseCase findInventoryByProductIdUseCase(
            FindInventoryByProductIdAdapter findInventoryByProductIdAdapter
    ) {
        return new FindInventoryByProductIdUseCase(findInventoryByProductIdAdapter);
    }

}
