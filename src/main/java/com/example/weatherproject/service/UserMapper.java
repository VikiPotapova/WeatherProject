package com.example.weatherproject.service;

import com.example.weatherproject.DTO.UserDto;
import com.example.weatherproject.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto mapToDto(User user) {
        UserDto userDto = UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .login(user.getLogin())
                .build();
        return userDto;
    }
}
