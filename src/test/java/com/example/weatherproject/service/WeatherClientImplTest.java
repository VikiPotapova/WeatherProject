package com.example.weatherproject.service;

import com.example.weatherproject.DTO.WeatherDto;
import com.example.weatherproject.exceptionHandler.ResponseReadingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@ExtendWith(MockitoExtension.class)
class WeatherClientImplTest {
    @Mock
    RestTemplate restTemplate;
    WeatherClientImpl weatherClientImpl;

    private WeatherDto weatherDtoForTest;
    private static final String RESULT = """
            {
                             "address": "London",
                             "timezone": "Europe/London",
                             "description": "Similar temperatures continuing with a chance of rain tomorrow & Sunday.",
                             "days": [
                                 {
                                     "datetime": "2024-04-26",
                                     "tempmax": 54.9,
                                     "tempmin": 40.5,
                                     "temp": 47.2,
                                     "humidity": 64.7,
                                     "preciptype": [
                                         "rain"
                                     ],
                                     "conditions": "Overcast",
                                     "description": "Cloudy skies throughout the day.",
                                     "icon": "cloudy",
                                     "stations": [
                                         "EGWU",
                                         "EGLL",
                                         "D5621",
                                         "EGLC"
                                     ]
                                     }]}
            """;

    @BeforeEach
    void setUp() {
        weatherClientImpl = new WeatherClientImpl(restTemplate, new ObjectMapper(), "test", "test");
        weatherDtoForTest = WeatherDto.builder()
                .city("London")
                .temperature(47)
                .localDateTime(LocalDateTime.now())
                .build();
    }

    @Test
    void getWeatherFromApiTest() throws ResponseReadingException {
        ResponseEntity<String> response = new ResponseEntity<>(RESULT, HttpStatus.OK);
        Mockito.when(restTemplate.getForEntity("testLondon?key=test",
                String.class)).thenReturn(response);
        WeatherDto returnedWeatherDto = weatherClientImpl.getWeatherFromApi(weatherDtoForTest.getCity());
        Assertions.assertNotNull(returnedWeatherDto);
    }

}