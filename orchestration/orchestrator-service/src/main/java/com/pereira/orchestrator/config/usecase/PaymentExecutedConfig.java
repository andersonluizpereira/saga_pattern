package com.pereira.orchestrator.config.usecase;

import com.pereira.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.pereira.orchestrator.application.core.usecase.PaymentExecutedUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentExecutedConfig {

    @Bean
    public PaymentExecutedUseCase paymentExecutedUseCase(
            SendSaleToTopicAdapter sendSaleToTopicAdapter
    ) {
        return new PaymentExecutedUseCase(sendSaleToTopicAdapter);
    }

}