package com.pereira.payment.application.ports.in;

import com.pereira.payment.application.core.domain.User;

public interface FindUserByIdInputPort {
    User find(final Integer id);
}
