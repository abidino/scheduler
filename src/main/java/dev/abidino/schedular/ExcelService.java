package dev.abidino.schedular;

import org.springframework.stereotype.Service;

@Service
public record ExcelService(SomeDependency someDependency) {
    Runnable createTask(TaskDefinition taskDefinition) {
        return () -> someDependency.log("excel : " + taskDefinition.data());
    }
}
