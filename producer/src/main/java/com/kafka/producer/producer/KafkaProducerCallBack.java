package com.kafka.producer.producer;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.kafka.core.KafkaTemplate;

@Slf4j
@RequiredArgsConstructor
public class KafkaProducerCallBack implements Callback {
//    private final KafkaTemplate<String, String> producer;

    @Override
    public void onCompletion(RecordMetadata metadata, Exception exception) {
        if (exception != null) {
            exception.getStackTrace();
        } else {
            log.info(metadata.topic() + " success : {}", metadata);
        }
    }
}
