package dev.abidino.scheduler.data;

import dev.abidino.scheduler.business.TaskDefinition;
import dev.abidino.scheduler.business.TaskStatus;
import dev.abidino.scheduler.business.TaskType;
import jakarta.persistence.*;

@Entity
@Table
public class TaskDefinitionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cronExpression;
    private TaskType taskType;
    private String data;

    private TaskStatus taskStatus;

    public TaskDefinitionEntity(Long id, String cronExpression, TaskType taskType, String data, TaskStatus taskStatus) {
        this.id = id;
        this.cronExpression = cronExpression;
        this.taskType = taskType;
        this.data = data;
        this.taskStatus = taskStatus;
    }

    public TaskDefinitionEntity(TaskDefinition taskDefinition) {
        this.id = taskDefinition.id();
        this.cronExpression = taskDefinition.cronExpression();
        this.taskType = taskDefinition.taskType();
        this.data = taskDefinition.data();
        this.taskStatus = taskDefinition.taskStatus();
    }

    public TaskDefinitionEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public String getData() {
        return data;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }
}
