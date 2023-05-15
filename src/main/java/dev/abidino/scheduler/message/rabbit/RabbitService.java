package dev.abidino.scheduler.message.rabbit;

import dev.abidino.scheduler.message.MessageService;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public record RabbitService(RabbitTemplate rabbitTemplate, TopicExchange topicExchange) implements MessageService {

    @Override
    public void sendMessage(String routingKey, String message) {
        try {

            rabbitTemplate.convertAndSend(topicExchange.getName(), routingKey, message);

        } catch (Exception e) {
            System.out.printf(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}
