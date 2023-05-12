package dev.abidino.scheduler.message.kafka;

import dev.abidino.scheduler.message.MessageService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public record MessageServiceImpl(KafkaTemplate<String, String> kafkaTemplate) implements MessageService {

    @Override
    public void sendMessage(String topic, String message) {
        kafkaTemplate.send(topic, message);
    }
}
