package com.example.weatherproject.service;

import com.example.weatherproject.DTO.WeatherDto;
import com.example.weatherproject.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherClient weatherClient;
    private final WeatherRepository weatherRepository;
    private final WeatherMapper weatherMapper;

    @Override
    public WeatherDto getWeather(String city) {
        WeatherDto weatherDto = weatherClient.getWeatherFromApi(city);
        weatherRepository.save(weatherMapper.mapToEntity(weatherDto));
        return weatherDto;
    }
}
