package com.example.weatherproject.kafka;

import com.example.weatherproject.model.Weather;
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

    private final KafkaTemplate<String, Weather> kafkaTemplate;

    public void sendMessageToKafkaTopic(Weather weather) {
        CompletableFuture<SendResult<String, Weather>> future = kafkaTemplate.send("weather_info", weather);

        future.whenComplete((result, ex) -> {

            if (ex != null) {
                System.out.println("Unable to send message=["
                        + weather + "] due to : " + ex.getMessage());
            } else {
                System.out.println("Sent message=[" + weather +
                        "] with offset=[" + result.getRecordMetadata().offset() + "]" + "partition=[" + result.getRecordMetadata().partition() + "]");
            }
        });
    }
}