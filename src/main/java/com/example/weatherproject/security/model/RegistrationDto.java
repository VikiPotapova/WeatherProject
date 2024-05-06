package com.example.weatherproject.security.model;

import lombok.Data;

@Data
public class RegistrationDto {

    private String firstName;
    private String lastName;
    private String login;
    private String password;
}
