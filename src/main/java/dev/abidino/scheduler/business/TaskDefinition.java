package dev.abidino.scheduler.business;

import dev.abidino.scheduler.data.TaskDefinitionEntity;
import dev.abidino.scheduler.web.TaskDefinitionDto;

public record TaskDefinition(Long id, String cronExpression, TaskType taskType, String data, TaskStatus taskStatus) {
    public TaskDefinition(TaskDefinitionDto taskDefinitionDto) {
        this(taskDefinitionDto.id(), taskDefinitionDto.cronExpression(), taskDefinitionDto.taskType(), taskDefinitionDto.data(), taskDefinitionDto.taskStatus());
    }

    public TaskDefinition(TaskDefinitionEntity taskDefinitionEntity) {
        this(taskDefinitionEntity.getId(), taskDefinitionEntity.getCronExpression(), taskDefinitionEntity.getTaskType(), taskDefinitionEntity.getData(), taskDefinitionEntity.getTaskStatus());
    }
}