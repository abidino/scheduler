package dev.abidino.scheduler.message.kafka;

import dev.abidino.scheduler.message.MessageService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public record KafkaService(KafkaTemplate<String, String> kafkaTemplate) implements MessageService {

    @Override
    public void sendMessage(String queue, String message) {
        kafkaTemplate.send(queue, message);
    }
}
