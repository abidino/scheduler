package dev.abidino.scheduler.business;

import dev.abidino.scheduler.data.DataService;
import dev.abidino.scheduler.data.TaskDefinitionEntity;
import dev.abidino.scheduler.task.TaskFacadeService;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final DataService dataService;
    private final TaskFacadeService taskFacadeService;

    public TaskServiceImpl(DataService dataService, TaskFacadeService taskFacadeService) {
        this.dataService = dataService;
        this.taskFacadeService = taskFacadeService;
    }

    @Override
    @Transactional
    public void save(TaskDefinition taskDefinition) {
        TaskDefinitionEntity taskDefinitionEntity = new TaskDefinitionEntity(taskDefinition);
        TaskDefinitionEntity savedTaskDefinitionEntity = dataService.save(taskDefinitionEntity);
        taskFacadeService.addTask(new TaskDefinition(savedTaskDefinitionEntity));
    }

    @Override
    @Transactional
    public void update(TaskDefinition taskDefinition, Long id) {
        if (dataService.existById(id)) {
            taskFacadeService.removeTask(id);
            TaskDefinitionEntity taskDefinitionEntity = new TaskDefinitionEntity(taskDefinition);
            dataService.update(taskDefinitionEntity, id);
            return;
        }
        throw new IllegalArgumentException("Entity not found");
    }

    @Override
    public List<TaskDefinition> findAll() {
        return dataService.findAll().stream().map(TaskDefinition::new).toList();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        dataService.delete(id);
        taskFacadeService.removeTask(id);
    }

    @PostConstruct
    public void addScheduler() {
        List<TaskDefinition> taskDefinitionList = dataService.findAllByTaskStatus(TaskStatus.ACTIVE).stream().map(TaskDefinition::new).toList();
        taskDefinitionList.forEach(taskFacadeService::addTask);
    }
}
