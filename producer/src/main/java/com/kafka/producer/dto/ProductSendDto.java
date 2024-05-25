package com.kafka.producer.dto;

import com.kafka.producer.enums.KafkaTopic;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductSendDto<T> {
    @NotNull
    private KafkaTopic topic;

    @Nullable
    private String key;

    @NotNull
    private T payload;

}
