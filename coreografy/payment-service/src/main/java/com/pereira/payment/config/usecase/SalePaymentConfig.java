package com.pereira.payment.config.usecase;

import com.pereira.payment.adapters.out.SavePaymentAdapter;
import com.pereira.payment.adapters.out.SendValidatedPaymentAdapter;
import com.pereira.payment.adapters.out.UpdateUserAdapter;
import com.pereira.payment.application.core.usecase.FindUserByIdUseCase;
import com.pereira.payment.application.core.usecase.SalePaymentUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SalePaymentConfig {
    @Bean
    public SalePaymentUseCase salePaymentUseCase(
            FindUserByIdUseCase findUserByIdUseCase,
            UpdateUserAdapter updateUserAdapter,
            SavePaymentAdapter savePaymentAdapter,
            SendValidatedPaymentAdapter sendValidatedPaymentAdapter
    ) {
        return new SalePaymentUseCase(
                findUserByIdUseCase,
                updateUserAdapter,
                savePaymentAdapter,
                sendValidatedPaymentAdapter
        );
    }

}
