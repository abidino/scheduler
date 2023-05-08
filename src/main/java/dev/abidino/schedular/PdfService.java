package dev.abidino.schedular;

import com.google.gson.Gson;
import dev.abidino.schedular.kafka.MessageService;
import org.springframework.stereotype.Service;

@Service
public record PdfService(MessageService messageService, Gson gson) {

    Runnable createTask(TaskDefinition taskDefinition) {
        return () -> messageService.sendMessage("test-topic", gson.toJson(taskDefinition));
    }
}
