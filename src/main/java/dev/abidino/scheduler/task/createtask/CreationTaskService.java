package dev.abidino.scheduler.task.createtask;

import dev.abidino.scheduler.business.TaskDefinition;

public interface CreationTaskService {
    Runnable createTask(TaskDefinition taskDefinition);
}
