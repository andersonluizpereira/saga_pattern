package com.pereira.payment.application.ports.out;

import com.pereira.payment.application.core.domain.User;

public interface UpdateUserOutputPort {
    void update(User user);
}
