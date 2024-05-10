package com.example.weatherproject.service;

import com.example.weatherproject.model.User;

public interface UserService {
    User getUserByLogin(String login);
}
