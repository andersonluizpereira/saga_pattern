package com.pereira.payment.payment.application.ports.out;

import com.pereira.payment.payment.application.core.domain.User;

import java.util.Optional;

public interface FindUserByIdOutputPort {

    Optional<User> find(Integer userId);

}
