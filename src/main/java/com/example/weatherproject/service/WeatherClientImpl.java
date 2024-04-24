package com.example.weatherproject.service;

import com.example.weatherproject.DTO.WeatherDto;
import com.example.weatherproject.exceptionHandler.ResponseReadingException;
import com.example.weatherproject.model.Weather;
import com.example.weatherproject.repository.WeatherRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Component
@Data
@RequiredArgsConstructor
public class WeatherClientImpl implements WeatherClient {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    @Value("${weather.clint.endpoint.key}")
    private String key;
    @Value("${weather.clint.endpoint.url}")
    private String constantPartOfUrl;

    @Override
    public WeatherDto getWeatherFromApi(String city) {
        String url = constantPartOfUrl + city + "?key=" + key;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return readAndConvertToDto(city, response);
    }

    private WeatherDto readAndConvertToDto(String city, ResponseEntity<String> response) {
        JsonNode root;
        try {
            root = objectMapper.readTree(response.getBody());
        } catch (JsonProcessingException e) {
            throw new ResponseReadingException(e);
        }
        Integer tempValue = root.get("days").get(0).get("temp").intValue();
        return WeatherDto.builder()
                .city(city)
                .temperature(tempValue)
                .localDateTime(LocalDateTime.now())
                .build();
    }
}
