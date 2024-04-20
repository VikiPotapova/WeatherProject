package com.example.weatherproject.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherDto {

    @NotBlank
    private String city;

    @NotNull
    private Integer temperature;

    @NotNull
    private LocalDateTime localDateTime;
}
