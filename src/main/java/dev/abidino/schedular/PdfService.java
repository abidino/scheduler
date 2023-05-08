package dev.abidino.schedular;

import org.springframework.stereotype.Service;

@Service
public record PdfService(SomeDependency someDependency) {

    Runnable createTask(TaskDefinition taskDefinition) {
        return () -> someDependency.log("pdf : " + taskDefinition.data());
    }
}
