package com.example.weatherproject.service;

import com.example.weatherproject.model.Weather;

import java.time.LocalDateTime;

public interface WeatherClientService {
    public Weather getWeather();
}
