package dev.abidino.schedular;

public record TaskDefinition(String id, String cronExpression, TaskType taskType, String data) {
}

enum TaskType {
    EXCEL,
    PDF
}