package com.example.weatherproject.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Weather {
    private String city;
    private Integer temperature;
    private LocalDateTime localDateTime;
}
