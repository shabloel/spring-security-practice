package com.practice.security.securitypractice.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class SecurityUserDetails implements UserDetails {

    private final SimpleUser simpleUser;

    public SecurityUserDetails(SimpleUser simpleUser) {
        this.simpleUser = simpleUser;
    }

    public SimpleUser getSimpleUser(){
        return this.simpleUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return simpleUser.getAuthorities().stream()
                .map(a -> new SimpleGrantedAuthority(a.getAuthorityName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.simpleUser.getPassword();
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
