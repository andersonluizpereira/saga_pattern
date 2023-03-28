package com.pereira.payment.adapters.out;

import com.pereira.payment.adapters.out.repository.UserRepository;
import com.pereira.payment.adapters.out.repository.mapper.UserEntityMapper;
import com.pereira.payment.application.core.domain.User;
import com.pereira.payment.application.ports.out.UpdateUserOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateUserAdapter implements UpdateUserOutputPort {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserEntityMapper userEntityMapper;
    @Override
    public void update(User user) {
        var userEntity = userEntityMapper.toUserEntity(user);
        userRepository.save(userEntity);
    }
}
