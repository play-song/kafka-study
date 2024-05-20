package com.kafka.producer.kafka;

import com.kafka.producer.ProducerApplicationTests;
import com.kafka.producer.config.LocalKafka;
import com.kafka.producer.enums.KafkaTopic;
import com.kafka.producer.producer.KafkaProducer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


@LocalKafka
public class EmbeddedKafkaIntegrationTest extends ProducerApplicationTests {

    @Autowired
    KafkaProducer producer;

    @Test
    @DisplayName("producer 토픽 전송 테스트")
    public void send() {
        producer.send(KafkaTopic.TEST.getName(), "hello");
    }

}
