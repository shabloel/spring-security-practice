package com.practice.security.securitypractice.controllers;

import com.practice.security.securitypractice.dto.Guitar;
import com.practice.security.securitypractice.services.GuitarServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class guitars {

    @Autowired
    private final GuitarServiceImpl guitarService;

    @GetMapping("/guitars")
    public List<Guitar> getGuitars(){
        Guitar fender = Guitar.builder()
                .id(1)
                .brand("Fender")
                .model("Stratocaster")
                .genre("All-round")
                .build();

        Guitar gibson = Guitar.builder()
                .id(2)
                .brand("Gibson")
                .model("Les Paul")
                .genre("Heavy Rock")
                .build();

        return List.of(fender, gibson);
    }
}
