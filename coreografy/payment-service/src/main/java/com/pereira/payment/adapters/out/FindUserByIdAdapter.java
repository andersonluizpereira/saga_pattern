package com.pereira.payment.adapters.out;

import com.pereira.payment.adapters.out.repository.UserRepository;
import com.pereira.payment.adapters.out.repository.mapper.UserEntityMapper;
import com.pereira.payment.application.core.domain.User;
import com.pereira.payment.application.ports.out.FindUserByIdOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindUserByIdAdapter implements FindUserByIdOutPutPort {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserEntityMapper userEntityMapper;

    @Override
    public Optional<User> find(Integer userId) {
        var userEntity = userRepository.findById(userId);
        return userEntity.map(userEntityMapper::toUser);
    }
}
