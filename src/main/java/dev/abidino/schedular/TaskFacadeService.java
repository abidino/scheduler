package dev.abidino.schedular;

import org.springframework.stereotype.Service;

@Service
public record TaskFacadeService(TaskService taskService) {
    public void schedule(TaskDefinition taskDefinition) {
        switch (taskDefinition.taskType()){
            case PDF -> {
                Runnable pdfTaskService = new PdfTaskService(taskDefinition);
                taskService.addTask(taskDefinition, pdfTaskService);
            }
            case EXCEL -> {
                Runnable excelTaskService = new ExcelTaskService(taskDefinition);
                taskService.addTask(taskDefinition, excelTaskService);
            }
        }
    }
}
