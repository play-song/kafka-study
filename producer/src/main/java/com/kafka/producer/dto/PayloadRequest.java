package com.kafka.producer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class PayloadRequest {
    private List<item> items;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class item {
        private String key;
        private String value;
    }
}
