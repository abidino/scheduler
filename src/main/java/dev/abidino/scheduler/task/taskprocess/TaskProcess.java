package dev.abidino.scheduler.task.taskprocess;

import dev.abidino.scheduler.business.TaskDefinition;

public interface TaskProcess {
    void addTask(TaskDefinition taskDefinition, Runnable runnable);

    void removeTask(Long taskId);
}
