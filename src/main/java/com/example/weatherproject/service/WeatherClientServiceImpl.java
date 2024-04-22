package com.example.weatherproject.service;

import com.example.weatherproject.DTO.WeatherDto;
import com.example.weatherproject.model.Weather;
import com.example.weatherproject.repository.WeatherRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
@Data
@RequiredArgsConstructor
public class WeatherClientServiceImpl implements WeatherClientService {

    private final WeatherRepository weatherRepository;
    private final WeatherMapper weatherMapper;

    @Override
    public WeatherDto getWeather(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String key = "GRZBBGS4R42SZL3XUUAWW9CNK";
        String url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/" + city + "?key=" + key;
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root;
        try {
            root = mapper.readTree(response.getBody());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Integer tempValue = root.get("days").get(0).get("temp").intValue();
        Weather weather = Weather.builder()
                .city(city)
                .temperature(tempValue)
                .localDateTime(LocalDateTime.now())
                .build();
        weatherRepository.save(weather);
        return weatherMapper.mapToDto(weather);

    }
}
