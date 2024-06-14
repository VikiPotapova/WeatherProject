package com.example.weatherproject.kafka;

import com.example.weatherproject.DTO.WeatherDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageProducer {

    private final KafkaTemplate<String, WeatherDto> kafkaTemplate;

    public void sendMessageToKafkaTopic(WeatherDto weatherDto) {
        CompletableFuture<SendResult<String, WeatherDto>> future = kafkaTemplate.send("weather_info", weatherDto);

        future.whenComplete((result, ex) -> {

            if (ex != null) {
                System.out.println("Unable to send message=["
                        + weatherDto + "] due to : " + ex.getMessage());
            } else {
                System.out.println("Sent message=[" + weatherDto +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]" + "partition=[" + result.getRecordMetadata().partition() + "]");
            }
        });
    }
}