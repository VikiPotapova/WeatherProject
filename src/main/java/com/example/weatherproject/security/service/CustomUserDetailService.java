package com.example.weatherproject.security.service;

import com.example.weatherproject.model.User;
import com.example.weatherproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userFromDataBase = userService.getUserByLogin(username);
        return org.springframework.security.core.userdetails.User
                .withUsername(userFromDataBase.getLogin())
                .password(userFromDataBase.getPassword())
                .roles(userFromDataBase.getRole().toString())
                .build();
    }
}
