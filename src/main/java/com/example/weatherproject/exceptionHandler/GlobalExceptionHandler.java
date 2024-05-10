package com.example.weatherproject.exceptionHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RestClientException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleRestClientException(RestClientException e) {
        log.error(e.getMessage());
        return new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                e.getMessage(),
                LocalDateTime.now());
    }

    @ExceptionHandler(ResponseReadingException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErrorResponse handleResponseReadingException(ResponseReadingException e) {
        log.error(e.getMessage());
        return new ErrorResponse(
                HttpStatus.UNPROCESSABLE_ENTITY.value(),
                e.getMessage(),
                LocalDateTime.now());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleUserNotFoundException(UserNotFoundException e) {
        log.error(e.getMessage());
        return new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                e.getMessage(),
                LocalDateTime.now());
    }

    @ExceptionHandler(SameUserInDatabaseException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleSameUserInDatabaseException(SameUserInDatabaseException e) {
        log.error(e.getMessage());
        return new ErrorResponse(
                HttpStatus.CONFLICT.value(),
                e.getMessage(),
                LocalDateTime.now());
    }
}
