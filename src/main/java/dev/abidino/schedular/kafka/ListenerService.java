package dev.abidino.schedular.kafka;

import com.google.gson.Gson;
import dev.abidino.schedular.TaskDefinition;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public record ListenerService(Gson gson) {

    @KafkaListener(topics = "test-topic")
    public void listener(String message) {
        TaskDefinition taskDefinition = gson.fromJson(message, TaskDefinition.class);
        System.out.println(taskDefinition.data());
    }
}
