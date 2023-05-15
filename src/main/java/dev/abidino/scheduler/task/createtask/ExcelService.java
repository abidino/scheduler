package dev.abidino.scheduler.task.createtask;

import com.google.gson.Gson;
import dev.abidino.scheduler.business.TaskDefinition;
import dev.abidino.scheduler.message.MessageService;
import org.springframework.amqp.core.Binding;
import org.springframework.stereotype.Service;

@Service
public record ExcelService(MessageService rabbitService, Gson gson, Binding excelBinding) implements CreationTaskService {
    @Override
    public Runnable createTask(TaskDefinition taskDefinition) {
        return () -> rabbitService.sendMessage(excelBinding.getRoutingKey(), gson.toJson(taskDefinition.data()));
    }
}
