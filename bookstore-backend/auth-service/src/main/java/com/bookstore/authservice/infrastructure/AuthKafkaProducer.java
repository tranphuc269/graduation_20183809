package com.bookstore.authservice.infrastructure;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthKafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public AuthKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(
            String topic,
            Object object
    ) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";

        try {
            jsonInString = mapper.writeValueAsString(object);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        kafkaTemplate.send(topic, jsonInString);

        log.info("Kafka Auth sent data with topic : " + topic + ", with data : " + object);
    }
}