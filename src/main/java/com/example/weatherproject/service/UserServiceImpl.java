package com.example.weatherproject.service;

import com.example.weatherproject.DTO.UserDto;
import com.example.weatherproject.exceptionHandler.UserNotFoundException;
import com.example.weatherproject.model.User;
import com.example.weatherproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();
        for(User user : userList) {
            userDtoList.add(userMapper.mapToDto(user));
        }
        return userDtoList;
    }

    @Override
    public User getUserByLogin(String login) {
        return userRepository.getByLogin(login).orElseThrow(() ->
                new UserNotFoundException("User with login: " + login + " not found"));
    }
}
