package dev.abidino.scheduler.message.kafka;

import com.google.gson.Gson;
import dev.abidino.scheduler.business.TaskDefinition;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public record ListenerService(Gson gson) {

    @KafkaListener(topics = "excel-topic")
    public void listenerExcel(String message) {
        TaskDefinition taskDefinition = gson.fromJson(message, TaskDefinition.class);
        System.out.println("Excel topic");
        System.out.println(taskDefinition.data());
    }

    @KafkaListener(topics = "csv-topic")
    public void listenerCsv(String message) {
        TaskDefinition taskDefinition = gson.fromJson(message, TaskDefinition.class);
        System.out.println("Csv topic");
        System.out.println(taskDefinition.data());
    }
}
