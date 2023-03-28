package com.pereira.payment.adapters.out.repository;

import com.pereira.payment.adapters.out.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
