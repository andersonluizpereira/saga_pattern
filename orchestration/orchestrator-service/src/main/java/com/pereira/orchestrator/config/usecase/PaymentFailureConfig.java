package com.pereira.orchestrator.config.usecase;

import com.pereira.orchestrator.adapters.out.SendSaleToTopicAdapter;
import com.pereira.orchestrator.application.core.usecase.PaymentExecutedUseCase;
import com.pereira.orchestrator.application.core.usecase.PaymentFailureUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PaymentFailureConfig {
    @Bean
    public PaymentFailureUseCase paymentFailureUseCase(SendSaleToTopicAdapter sendSaleToTopicAdapter) {
        return new PaymentFailureUseCase(sendSaleToTopicAdapter);
    }
}