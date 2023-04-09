package com.pereira.payment.payment.application.ports.in;

import com.pereira.payment.payment.application.core.domain.User;

public interface FindUserByIdInputPort {

    User find(final Integer id);

}
