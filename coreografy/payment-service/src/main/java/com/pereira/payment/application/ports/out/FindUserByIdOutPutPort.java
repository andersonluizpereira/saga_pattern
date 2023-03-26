package com.pereira.payment.application.ports.out;

import com.pereira.payment.application.core.domain.User;

import java.util.Optional;

public interface FindUserByIdOutPutPort {
    Optional<User> find(Integer userId);
}
