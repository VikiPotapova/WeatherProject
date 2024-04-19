package com.example.weatherproject.controller;

import com.example.weatherproject.model.DTO.WeatherDTO;
import com.example.weatherproject.model.Weather;
import com.example.weatherproject.service.WeatherClientService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherClientService weatherClientService;
    private final ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<WeatherDTO> getWeather() {
        Weather weather = weatherClientService.getWeather();
        return new ResponseEntity<>(modelMapper.map(weather, WeatherDTO.class), HttpStatus.OK);
    }
}
