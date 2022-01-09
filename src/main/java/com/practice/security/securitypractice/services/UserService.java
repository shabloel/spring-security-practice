package com.practice.security.securitypractice.services;

import com.practice.security.securitypractice.dto.SecurityUserDetails;
import com.practice.security.securitypractice.dto.SimpleUser;
import com.practice.security.securitypractice.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public SecurityUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Supplier<UsernameNotFoundException> s =
                () -> new UsernameNotFoundException("Problem during authentication");

        SimpleUser simpleUser = userRepository.findUserByname(username).orElseThrow(s);

        return new SecurityUserDetails(simpleUser);
    }
}
