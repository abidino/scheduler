package dev.abidino.scheduler.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public record MessageService(KafkaTemplate<String, String> kafkaTemplate) {

    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}
