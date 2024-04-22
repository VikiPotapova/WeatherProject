package com.example.weatherproject.controller;

import com.example.weatherproject.DTO.WeatherDto;
import com.example.weatherproject.exceptionHandler.CityNotFoundException;
import com.example.weatherproject.service.WeatherClientService;
import lombok.RequiredArgsConstructor;
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

    private final WeatherClientService weatherClientService;

    @GetMapping("/{city}")
    public ResponseEntity<WeatherDto> getWeather(@PathVariable String city) {
        Optional<WeatherDto> weatherDto = Optional.ofNullable(weatherClientService.getWeather(city));
        return weatherDto.map(ResponseEntity::ok)
                .orElseThrow(() -> new CityNotFoundException("The city is not found"));
    }
}
