package com.example.weatherproject.service;

import com.example.weatherproject.exceptionHandler.UserNotFoundException;
import com.example.weatherproject.model.User;
import com.example.weatherproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUserByLogin(String login) {
        return userRepository.getByLogin(login).orElseThrow(() ->
                new UserNotFoundException("User with login: " + login + " not found"));
    }
}
