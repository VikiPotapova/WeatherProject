package com.example.weatherproject.controller;

import com.example.weatherproject.DTO.UserDto;
import com.example.weatherproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping()
    public ResponseEntity<List<UserDto>> getAll() {
        Optional<List<UserDto>> userDtoOptional = Optional.ofNullable(userService.getAllUsers());
        return userDtoOptional.isPresent() ? ResponseEntity.ok(userDtoOptional.get()) : ResponseEntity.notFound().build();
    }
}
