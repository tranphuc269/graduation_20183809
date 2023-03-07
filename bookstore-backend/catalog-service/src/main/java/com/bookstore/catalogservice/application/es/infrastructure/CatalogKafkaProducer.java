package com.bookstore.catalogservice.application.es.infrastructure;

import com.bookstore.catalogservice.common.infrastructure.kafka.product_order.KafkaSendProductCreateCartItem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Slf4j
public class CatalogKafkaProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public CatalogKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
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

        log.info("Kafka Catalog sent data with topic : " + topic + ", with data : " + object);
    }
}
