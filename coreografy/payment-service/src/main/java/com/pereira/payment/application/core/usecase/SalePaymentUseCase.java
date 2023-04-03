package com.pereira.payment.application.core.usecase;

import com.pereira.payment.application.core.domain.Payment;
import com.pereira.payment.application.core.domain.Sale;
import com.pereira.payment.application.core.domain.enums.SaleEvent;
import com.pereira.payment.application.ports.in.FindUserByIdInputPort;
import com.pereira.payment.application.ports.in.SalePaymentInputPort;
import com.pereira.payment.application.ports.out.SavePaymentOutputPort;
import com.pereira.payment.application.ports.out.SendToKafkaOutputPort;
import com.pereira.payment.application.ports.out.UpdateUserOutputPort;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SalePaymentUseCase implements SalePaymentInputPort {
    private final FindUserByIdInputPort findUserByIdInputPort;
    private final UpdateUserOutputPort updateUserOutputPort;

    private final SavePaymentOutputPort savePaymentOutputPort;

    private final SendToKafkaOutputPort sendToKafkaOutputPort;

    public SalePaymentUseCase(FindUserByIdInputPort findUserByIdInputPort, UpdateUserOutputPort updateUserOutputPort, SavePaymentOutputPort savePaymentOutputPort, SendToKafkaOutputPort sendToKafkaOutputPort) {
        this.findUserByIdInputPort = findUserByIdInputPort;
        this.updateUserOutputPort = updateUserOutputPort;
        this.savePaymentOutputPort = savePaymentOutputPort;
        this.sendToKafkaOutputPort = sendToKafkaOutputPort;
    }

    @Override
    public void payment(Sale sale){
        try {
            var user = findUserByIdInputPort.find(sale.getUserId());
            if(user.getBalance().compareTo(sale.getValue()) < 0){
                throw new RuntimeException("User does not have enough balance");
            }
            user.debitBalance(sale.getValue());
            updateUserOutputPort.update(user);
            savePaymentOutputPort.save(buildPayment(sale));
            sendToKafkaOutputPort.send(sale, SaleEvent.VALIDATED_PAYMENT);
        } catch (RuntimeException e) {
            log.error("Error on payment {}", e.getMessage());
            sendToKafkaOutputPort.send(sale, SaleEvent.FAILED_PAYMENT);
        }
    }
    private Payment buildPayment(Sale sale){
        return new Payment(
                null,
                sale.getUserId(),
                sale.getId(),
                sale.getValue()
        );
    }
}
