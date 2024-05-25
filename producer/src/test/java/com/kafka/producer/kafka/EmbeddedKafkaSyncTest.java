package com.kafka.producer.kafka;

import com.kafka.producer.ProducerApplicationTests;
import com.kafka.producer.config.LocalKafka;
import com.kafka.producer.enums.KafkaTopic;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@LocalKafka
public class EmbeddedKafkaSyncTest extends ProducerApplicationTests {

    @Autowired
    private KafkaTemplate<String, String> producer;

    @Test
    @DisplayName("producer sync 테스트")
    public void sendSync() {
        try {
            RecordMetadata metadata = producer.send(KafkaTopic.TEST.getName(), "hello")
                    .get().getRecordMetadata();

            Assertions.assertEquals(metadata.topic(), KafkaTopic.TEST.getName());
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
