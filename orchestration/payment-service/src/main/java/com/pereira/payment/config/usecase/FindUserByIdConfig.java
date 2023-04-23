package com.pereira.payment.config.usecase;

import com.pereira.payment.adapters.out.FindUserByIdAdapter;
import com.pereira.payment.application.core.usecase.FindUserByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindUserByIdConfig {

    @Bean
    public FindUserByIdUseCase findUserByIdUseCase(
            FindUserByIdAdapter findUserByIdAdapter
    ) {
        return new FindUserByIdUseCase(findUserByIdAdapter);
    }

}
