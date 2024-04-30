package com.kafka.producer.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String, String> template;

    public void send(String topic, String payload) {
        log.info("topic={}, payload ={}", topic, payload);
        template.send(topic, payload);
    }

    public void send(String topic, String key, String payload) {
        log.info("topic={}, key={},  payload ={}", topic, key, payload);
        template.send(topic, key,  payload);
    }

}
