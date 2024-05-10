package com.example.weatherproject.service;

import com.example.weatherproject.DTO.WeatherDto;
import com.example.weatherproject.model.Weather;
import com.example.weatherproject.repository.WeatherRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class WeatherServiceImplTest {

    @Mock
    WeatherRepository weatherRepository;
    @Mock
    WeatherClient weatherClient;
    @Mock
    WeatherMapper weatherMapper;
    @InjectMocks
    WeatherServiceImpl weatherServiceImpl;

    private WeatherDto weatherDtoForTest;
    private Weather weatherForTest;

    @BeforeEach
    void setUp() {
        weatherDtoForTest = WeatherDto.builder()
                .city("Paris")
                .temperature(50)
                .localDateTime(LocalDateTime.now())
                .build();

        weatherForTest = Weather.builder()
                .city("Paris")
                .temperature(50)
                .localDateTime(weatherDtoForTest.getLocalDateTime())
                .build();
    }

    @Test
    void getWeatherTest() {
        Mockito.when(weatherClient.getWeatherFromApi(weatherDtoForTest.getCity())).thenReturn(weatherDtoForTest);
        Mockito.when(weatherMapper.mapToEntity(weatherDtoForTest)).thenReturn(weatherForTest);

        WeatherDto returnedWeather = weatherServiceImpl.getWeather(weatherDtoForTest.getCity());
        Mockito.verify(weatherRepository, Mockito.times(1)).save(any());
        Assertions.assertNotNull(returnedWeather);
    }
}