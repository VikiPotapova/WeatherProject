package com.example.weatherproject.service;

import com.example.weatherproject.DTO.UserDto;
import com.example.weatherproject.model.User;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    User getUserByLogin(String login);
}
