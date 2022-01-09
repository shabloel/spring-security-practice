package com.practice.security.securitypractice.services;

import com.practice.security.securitypractice.dto.Guitar;
import com.practice.security.securitypractice.repositories.GuitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuitarServiceImpl {

    @Autowired
    private GuitarRepository guitarRepository;

    public List<Guitar> findAll(){
        return guitarRepository.findAll();
    }
}
