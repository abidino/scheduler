package dev.abidino.scheduler.task.createtask;

import com.google.gson.Gson;
import dev.abidino.scheduler.business.TaskDefinition;
import dev.abidino.scheduler.message.kafka.MessageServiceImpl;
import org.springframework.stereotype.Service;

@Service
public record ExcelService(MessageServiceImpl messageServiceImpl, Gson gson) implements CreationTaskService {
    @Override
    public Runnable createTask(TaskDefinition taskDefinition) {
        return () -> messageServiceImpl.sendMessage("excel-topic", gson.toJson(taskDefinition));
    }
}
