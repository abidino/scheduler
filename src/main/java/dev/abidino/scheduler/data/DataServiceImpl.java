package dev.abidino.scheduler.data;

import dev.abidino.scheduler.business.TaskStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record DataServiceImpl(TaskDefinitionRepository taskDefinitionRepository) implements DataService {

    @Override
    public TaskDefinitionEntity save(TaskDefinitionEntity taskDefinitionEntity) {
        return taskDefinitionRepository.save(taskDefinitionEntity);
    }

    @Override
    public void update(TaskDefinitionEntity taskDefinitionEntity, Long id) {
        findById(id);
        save(taskDefinitionEntity);
    }

    @Override
    public boolean existById(Long id) {
        return taskDefinitionRepository.existsById(id);
    }

    @Override
    public TaskDefinitionEntity findById(Long id) {
        return taskDefinitionRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Entity not found"));
    }

    @Override
    public List<TaskDefinitionEntity> findAll() {
        return taskDefinitionRepository.findAll();
    }

    @Override
    public List<TaskDefinitionEntity> findAllByTaskStatus(TaskStatus taskStatus) {
        return taskDefinitionRepository.findAllByTaskStatus(taskStatus);
    }

    @Override
    public void delete(Long id) {
        TaskDefinitionEntity taskDefinitionEntity = findById(id);
        taskDefinitionRepository.delete(taskDefinitionEntity);
    }
}
