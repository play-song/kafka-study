package com.kafka.producer.config;

import org.springframework.kafka.test.context.EmbeddedKafka;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@EmbeddedKafka(
        partitions = 3,
        brokerProperties = {
                "listeners=PLAINTEXT://localhost:9092",
        },
        ports = {9092}
)
public @interface LocalKafka {

}
