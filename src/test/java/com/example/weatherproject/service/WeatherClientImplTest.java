package com.example.weatherproject.service;

import com.example.weatherproject.DTO.WeatherDto;
import com.example.weatherproject.exceptionHandler.ResponseReadingException;
import com.example.weatherproject.utils.UtilityForTest;
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
        ResponseEntity<String> response = new ResponseEntity<>(UtilityForTest.RESULT, HttpStatus.OK);
        Mockito.when(restTemplate.getForEntity("testLondon?key=test",
                String.class)).thenReturn(response);
        WeatherDto returnedWeatherDto = weatherClientImpl.getWeatherFromApi(weatherDtoForTest.getCity());
        Assertions.assertNotNull(returnedWeatherDto);
    }

}