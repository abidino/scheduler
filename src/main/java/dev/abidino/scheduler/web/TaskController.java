package dev.abidino.scheduler.web;

import dev.abidino.scheduler.business.TaskDefinition;
import dev.abidino.scheduler.business.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/tasks")
@RestController
public record TaskController(TaskService taskService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void save(@RequestBody TaskDefinitionDto taskDefinitionDto) {
        TaskDefinition taskDefinition = new TaskDefinition(taskDefinitionDto);
        taskService.save(taskDefinition);
    }

    @PutMapping("/{id}")
    void update(@RequestBody TaskDefinitionDto taskDefinitionDto, @PathVariable Long id) {
        TaskDefinition taskDefinition = new TaskDefinition(taskDefinitionDto);
        taskService.update(taskDefinition, id);
    }

    @GetMapping("/all")
    List<TaskDefinitionDto> all() {
        List<TaskDefinition> taskDefinitionList = taskService.findAll();
        return taskDefinitionList.stream().map(TaskDefinitionDto::new).toList();
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        taskService.delete(id);
    }
}
