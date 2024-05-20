package com.kafka.producer.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum KafkaTopic {
    TEST("test.topic");

    private final String name;
}
