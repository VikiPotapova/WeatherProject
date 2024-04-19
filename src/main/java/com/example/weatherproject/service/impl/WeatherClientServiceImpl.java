package com.example.weatherproject.service.impl;

import com.example.weatherproject.model.Weather;
import com.example.weatherproject.repository.WeatherRepository;
import com.example.weatherproject.service.WeatherClientService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Data
@RequiredArgsConstructor
public class WeatherClientServiceImpl implements WeatherClientService {

    private final WeatherRepository weatherRepository;

    @Override
    public Weather getWeather() {
        Weather weather = Weather.builder()
                .city("Minsk")
                .localDateTime(LocalDateTime.now())
                .temperature(5)
                .build();
        return weather;
    }
}
