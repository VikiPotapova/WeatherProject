package com.example.weatherproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*@Configuration
//@EnableCaching
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})*/
@SpringBootApplication
public class WeatherProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherProjectApplication.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
