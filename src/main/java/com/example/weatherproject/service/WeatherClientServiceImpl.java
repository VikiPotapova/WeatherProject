package com.example.weatherproject.service;

import com.example.weatherproject.DTO.WeatherDto;
import com.example.weatherproject.model.Weather;
import com.example.weatherproject.repository.WeatherRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Data
@RequiredArgsConstructor
public class WeatherClientServiceImpl implements WeatherClientService {

    private final WeatherRepository weatherRepository;
    private final WeatherMapper weatherMapper;

    public WeatherDto getWeather() {
        Weather weather = Weather.builder()
                .city("Minsk")
                .localDateTime(LocalDateTime.now())
                .temperature(5)
                .build();
        weatherRepository.save(weather);
        return weatherMapper.mapToDto(weather);

    }
}
