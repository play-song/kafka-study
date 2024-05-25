package com.kafka.producer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProducerResult {
    private int partition;
    private String topic;
    private long offset;
    private String key;
    private String value;
    private Long timestamp;
}
