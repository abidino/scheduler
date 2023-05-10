package dev.abidino.scheduler.task.createtask;

import com.google.gson.Gson;
import dev.abidino.scheduler.business.TaskDefinition;
import dev.abidino.scheduler.kafka.MessageService;
import org.springframework.stereotype.Service;

@Service
public record ExcelService(MessageService messageService, Gson gson) implements CreationTaskService {
    @Override
    public Runnable createTask(TaskDefinition taskDefinition) {
        return () -> messageService.sendMessage("excel-topic", gson.toJson(taskDefinition));
    }
}
