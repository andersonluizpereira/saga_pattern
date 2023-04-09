package com.pereira.payment.payment.application.ports.out;

import com.pereira.payment.payment.application.core.domain.User;

public interface UpdateUserOutputPort {

    void update(User user);

}
