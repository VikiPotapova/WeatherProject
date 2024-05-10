package com.example.weatherproject.exceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {

    private Integer httpStatusCode;
    private String message;
    private LocalDateTime localDateTime;
}
