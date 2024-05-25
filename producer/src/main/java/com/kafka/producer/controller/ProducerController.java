package com.kafka.producer.controller;

import com.kafka.producer.dto.ProducerResult;
import com.kafka.producer.dto.PayloadRequest;
import com.kafka.producer.enums.KafkaTopic;
import com.kafka.producer.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/producer")
public class ProducerController {
    private final KafkaProducer producer;

    @PostMapping("/async")
    public ResponseEntity<?> send(@RequestBody PayloadRequest request) {
        final List<ProducerResult> results = request.getItems().stream()
                .map(item -> producer.sendAsync(KafkaTopic.TEST, item))
                .collect(Collectors.toUnmodifiableList());
        return ResponseEntity.ok(results);
    }

    @PostMapping("/sync")
    public ResponseEntity<?> sendSync(@RequestBody PayloadRequest request) {
        final List<ProducerResult> results = request.getItems().stream()
                .map(item -> producer.sendSync(KafkaTopic.TEST, item.getKey(), item.getValue()))
                .collect(Collectors.toUnmodifiableList());
        return ResponseEntity.ok(results);
    }
}
