package dev.abidino.schedular;

public interface TaskService {
    void addTask(TaskDefinition taskDefinition, Runnable runnable);

    void removeTask(String taskId);
}
