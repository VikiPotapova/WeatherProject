package com.example.weatherproject.controller;

import com.example.weatherproject.DTO.WeatherDto;
import com.example.weatherproject.service.WeatherClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherClientService weatherClientService;

    @GetMapping
    public ResponseEntity<Optional<WeatherDto>> getWeather() {
        Optional<WeatherDto> weatherDTO = Optional.ofNullable(weatherClientService.getWeather());
        return new ResponseEntity<>(weatherDTO, HttpStatus.OK);
    }
}
