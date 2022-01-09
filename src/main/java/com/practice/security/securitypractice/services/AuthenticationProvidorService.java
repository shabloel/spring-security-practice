package com.practice.security.securitypractice.services;

import com.practice.security.securitypractice.dto.SecurityUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationProvidorService implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private SCryptPasswordEncoder sCryptPasswordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        SecurityUserDetails securityUserDetails = userService.loadUserByUsername(username);

        switch(securityUserDetails.getSimpleUser().getAlgorithm()){
            case BCRYPT:
                return checkPassword(securityUserDetails, password, bCryptPasswordEncoder);
            case SCRYPT:
                return checkPassword(securityUserDetails, password, sCryptPasswordEncoder);
        }
        throw new BadCredentialsException("Bad Credentials");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(authentication);
    }

    private Authentication checkPassword(SecurityUserDetails securityUserDetails,
                                         String rawPassword,
                                         PasswordEncoder encoder){
        if(encoder.matches(rawPassword, securityUserDetails.getPassword())){
            return new UsernamePasswordAuthenticationToken(
                    securityUserDetails.getUsername(),
                    securityUserDetails.getPassword(),
                    securityUserDetails.getAuthorities()
            );
        }else{
            throw new BadCredentialsException("Bad Credentials");
        }
    }
}
