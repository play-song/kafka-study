package com.kafka.producer.producer;

import com.kafka.producer.dto.ProducerResult;
import com.kafka.producer.enums.KafkaTopic;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String, Object> template;

    public <T> ProducerResult sendAsync(KafkaTopic topic, T payLoad) {
        try {
            SendResult<?, ?> result = template.send(topic.getName(), payLoad).whenCompleteAsync((complete, e) -> {
                if (e != null) {
                    log.error("topic send failed. ", e);
                    throw new RuntimeException();
                }
            }).get();

            return ProducerResult
                    .builder()
                    .offset(result.getRecordMetadata().offset())
                    .topic(result.getRecordMetadata().topic())
                    .partition(result.getRecordMetadata().partition())
                    .key(String.valueOf(result.getProducerRecord().key()))
                    .value(String.valueOf(result.getProducerRecord().value()))
                    .timestamp(result.getRecordMetadata().timestamp())
                    .build();

        } catch (Exception e) {
            log.error("topic send failed. ", e);
            throw new RuntimeException(e.getMessage());
        }
    }

    public <T> ProducerResult sendSync(KafkaTopic topic, String key, T payLoad) {
        try {
            SendResult<?, ?> result = template.send(topic.getName(), key, payLoad.toString()).whenComplete((complete, e) -> {
                if (e != null) {
                    log.error("topic send failed. ", e);
                    throw new RuntimeException();
                }
            }).get();

            return ProducerResult
                    .builder()
                    .offset(result.getRecordMetadata().offset())
                    .topic(result.getRecordMetadata().topic())
                    .partition(result.getRecordMetadata().partition())
                    .key(String.valueOf(result.getProducerRecord().key()))
                    .value(String.valueOf(result.getProducerRecord().value()))
                    .timestamp(result.getRecordMetadata().timestamp())
                    .build();

        } catch (Exception e) {
            log.error("topic send failed. ", e);
            throw new RuntimeException(e.getMessage());
        }
    }

}
