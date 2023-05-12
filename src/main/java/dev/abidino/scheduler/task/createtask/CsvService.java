package dev.abidino.scheduler.task.createtask;

import com.google.gson.Gson;
import dev.abidino.scheduler.business.TaskDefinition;
import dev.abidino.scheduler.message.MessageService;
import org.springframework.stereotype.Service;

@Service
public record CsvService(MessageService messageService, Gson gson) implements CreationTaskService {
    @Override
    public Runnable createTask(TaskDefinition taskDefinition) {
        return () -> messageService.sendMessage("csv-topic", gson.toJson(taskDefinition));
    }
}
