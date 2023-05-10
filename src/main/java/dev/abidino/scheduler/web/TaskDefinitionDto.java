package dev.abidino.scheduler.web;

import dev.abidino.scheduler.business.TaskDefinition;
import dev.abidino.scheduler.business.TaskStatus;
import dev.abidino.scheduler.business.TaskType;

public record TaskDefinitionDto(Long id, String cronExpression, TaskType taskType, String data, TaskStatus taskStatus) {
    public TaskDefinitionDto(TaskDefinition taskDefinition) {
        this(taskDefinition.id(), taskDefinition.cronExpression(), taskDefinition.taskType(), taskDefinition.data(), taskDefinition.taskStatus());
    }
}
