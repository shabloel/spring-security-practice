package com.practice.security.securitypractice.repositories;

import com.practice.security.securitypractice.dto.Guitar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuitarRepository extends JpaRepository<Guitar, Integer> {

}
