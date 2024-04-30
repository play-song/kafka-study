package com.kafka.producer;

import com.kafka.producer.producer.KafkaProducer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;

@SpringBootTest
@EmbeddedKafka(
        partitions = 3,
        brokerProperties = {
                "listeners=PLAINTEXT://localhost:9092",
//                "auto.create.topics.enable=${kafka.broker.topics-enable:true}"
        },
        topics = { "test.topic" },
        ports = { 9092 }
)
public class EmbeddedKafkaIntegrationTest {

    @Autowired
    KafkaProducer producer;

    @Test
    public void send() {
        producer.send("test.topic", "hello");

    }
}
