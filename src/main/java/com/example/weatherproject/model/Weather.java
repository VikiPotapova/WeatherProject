package com.example.weatherproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Weather {

    @Id
    @SequenceGenerator(name = "seq_weather", sequenceName = "weather_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_weather")
    private Long id;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Integer temperature;

    @Column(nullable = false)
    private LocalDateTime localDateTime;
}
