package dev.abidino.schedular;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/tasks")
@RestController
public record TaskController(TaskFacadeService taskFacadeService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void schedule(@RequestBody TaskDefinition taskDefinition){
        taskFacadeService.schedule(taskDefinition);
    }
}
