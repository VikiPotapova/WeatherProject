package com.example.weatherproject.service;

import com.example.weatherproject.DTO.WeatherDto;

public interface WeatherService {
    WeatherDto getWeather(String city);
}
