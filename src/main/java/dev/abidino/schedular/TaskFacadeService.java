package dev.abidino.schedular;

import org.springframework.stereotype.Service;

@Service
public record TaskFacadeService(TaskService taskService, PdfService pdfService, ExcelService excelService) {
    public void schedule(TaskDefinition taskDefinition) {
        switch (taskDefinition.taskType()) {
            case PDF -> {
                Runnable pdfTaskService = pdfService.createTask(taskDefinition);
                taskService.addTask(taskDefinition, pdfTaskService);
            }

            case EXCEL -> {
                Runnable excelTaskService = excelService.createTask(taskDefinition);
                taskService.addTask(taskDefinition, excelTaskService);
            }
            default -> throw new IllegalStateException("Unexpected value: " + taskDefinition.taskType());
        }
    }
}
