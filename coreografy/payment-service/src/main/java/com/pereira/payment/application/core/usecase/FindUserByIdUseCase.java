package com.pereira.payment.application.core.usecase;

import com.pereira.payment.application.core.domain.User;
import com.pereira.payment.application.ports.in.FindUserByIdInputPort;
import com.pereira.payment.application.ports.out.FindUserByIdOutPutPort;

public class FindUserByIdUseCase implements FindUserByIdInputPort {

    private final FindUserByIdOutPutPort findUserByIdOutPutPort;

    public FindUserByIdUseCase(
            FindUserByIdOutPutPort findUserByIdOutPutPort
    ) {
        this.findUserByIdOutPutPort = findUserByIdOutPutPort;
        ;
    }

    @Override
    public User find(final Integer id) {
        return findUserByIdOutPutPort.find(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
