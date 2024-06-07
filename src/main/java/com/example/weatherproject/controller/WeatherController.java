package com.example.weatherproject.controller;

import com.example.weatherproject.DTO.WeatherDto;
import com.example.weatherproject.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @Cacheable
    @GetMapping("/{city}")
    public ResponseEntity<WeatherDto> getWeather(@PathVariable String city) {
        Optional<WeatherDto> weatherDto = Optional.ofNullable(weatherService.getWeather(city));
        return weatherDto.map(ResponseEntity::ok)
                .orElseThrow();
    }
}
