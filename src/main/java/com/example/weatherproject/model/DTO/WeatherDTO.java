package com.example.weatherproject.model.DTO;

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
public class WeatherDTO {

    @NotBlank
    private String city;

    @NotNull
    private Integer temperature;

    @NotNull
    private LocalDateTime localDateTime;
}
