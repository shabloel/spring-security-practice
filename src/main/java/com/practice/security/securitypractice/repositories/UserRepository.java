package com.practice.security.securitypractice.repositories;

import com.practice.security.securitypractice.dto.SimpleUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<SimpleUser, Integer> {
    Optional<SimpleUser> findUserByname(String name);
}
