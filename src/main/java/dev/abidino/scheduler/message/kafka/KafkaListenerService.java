package dev.abidino.scheduler.message.kafka;

import com.google.gson.Gson;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public record KafkaListenerService(Gson gson) {

    @KafkaListener(topics = "excel-topic")
    public void listenerExcel(String message) {
        System.out.println(message);
    }

    @KafkaListener(topics = "csv-topic")
    public void listenerCsv(String message) {
        System.out.println(message);
    }
}
