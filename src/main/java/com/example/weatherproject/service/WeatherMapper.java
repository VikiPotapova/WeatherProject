package com.example.weatherproject.service;

import com.example.weatherproject.DTO.WeatherDto;
import com.example.weatherproject.model.Weather;
import org.springframework.stereotype.Component;

@Component
public class WeatherMapper {
    public WeatherDto mapToDto(Weather weather) {
        WeatherDto dto = WeatherDto.builder()
                .city(weather.getCity())
                .temperature(weather.getTemperature())
                .localDateTime(weather.getLocalDateTime())
                .build();
        return dto;
    }
}
