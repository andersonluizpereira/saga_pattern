package com.pereira.payment.adapters.out.repository.mapper;

import com.pereira.payment.adapters.out.repository.entity.UserEntity;
import com.pereira.payment.application.core.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserEntityMapper {

    User toUser(UserEntity userEntity);

    UserEntity toUserEntity(User user);

}
