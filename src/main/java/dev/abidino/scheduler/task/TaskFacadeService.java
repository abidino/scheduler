package dev.abidino.scheduler.task;

import dev.abidino.scheduler.business.TaskDefinition;
import dev.abidino.scheduler.task.createtask.CsvService;
import dev.abidino.scheduler.task.createtask.ExcelService;
import dev.abidino.scheduler.task.taskprocess.TaskProcess;
import org.springframework.stereotype.Service;

@Service
public record TaskFacadeService(TaskProcess taskProcess, CsvService csvService, ExcelService excelService) {
    public void addTask(TaskDefinition taskDefinition) {
        switch (taskDefinition.taskType()) {
            case CSV -> {
                Runnable csvTask = csvService.createTask(taskDefinition);
                taskProcess.addTask(taskDefinition, csvTask);
            }

            case EXCEL -> {
                Runnable excelTask = excelService.createTask(taskDefinition);
                taskProcess.addTask(taskDefinition, excelTask);
            }
            default -> throw new IllegalStateException("Unexpected value: " + taskDefinition.taskType());
        }
    }

    public void removeTask(Long id) {
        taskProcess.removeTask(id);
    }
}
