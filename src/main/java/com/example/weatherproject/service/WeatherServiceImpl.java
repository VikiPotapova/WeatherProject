package com.example.weatherproject.service;

import com.example.weatherproject.DTO.WeatherDto;
import com.example.weatherproject.kafka.MessageProducer;
import com.example.weatherproject.repository.WeatherRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherClient weatherClient;
    private final WeatherRepository weatherRepository;
    private final WeatherMapper weatherMapper;
    private final MessageProducer messageProducer;

    @Override
    public WeatherDto getWeather(String city) {
        WeatherDto weatherDto = weatherClient.getWeatherFromApi(city);
        weatherRepository.save(weatherMapper.mapToEntity(weatherDto));
        messageProducer.sendMessageToKafkaTopic(weatherDto);
        return weatherDto;
    }
}
