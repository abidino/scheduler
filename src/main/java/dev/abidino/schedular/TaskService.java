package dev.abidino.schedular;

public interface TaskService {
    void schedule(TaskDefinition taskDefinition, Runnable runnable);
}
