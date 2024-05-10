package com.example.weatherproject.service;

import com.example.weatherproject.DTO.WeatherDto;

public interface WeatherClient {
    public WeatherDto getWeatherFromApi(String city);
}
