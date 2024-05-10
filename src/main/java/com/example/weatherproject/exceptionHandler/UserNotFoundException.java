package com.example.weatherproject.exceptionHandler;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
